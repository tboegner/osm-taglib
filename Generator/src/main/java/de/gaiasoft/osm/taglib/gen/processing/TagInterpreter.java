package de.gaiasoft.osm.taglib.gen.processing;

import de.gaiasoft.osm.taglib.gen.aggregation.AggregationResult;
import de.gaiasoft.osm.taglib.gen.aggregation.KeyAdapter;
import de.gaiasoft.osm.taglib.gen.aggregation.ValueAdapter;
import de.gaiasoft.osm.taglib.gen.generation.KeyDefinition;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class TagInterpreter {
    private static final String KEY_VALUE_FILTER = "^[A-Za-z0-9_:]+$";

    public void interpretSegmentData(AggregationResult inputFromAggregation, KeySegment keySegment,
                                      InterpretationResult result) {
        printStatsHeader("Segment " + keySegment.name());

        computeKeyDefinitions(keySegment, inputFromAggregation.keySet, result);
        computeValueDefinitions(keySegment, inputFromAggregation.keyValueMappings, result);
        computeValueMappings(keySegment, inputFromAggregation.keyValueMappings, result);
    }

    private void computeKeyDefinitions(KeySegment segment, Set<KeyAdapter> keySet,
                                                     InterpretationResult result) {
        int countPrimary=0, countValueSet=0, countFreeValue=0;
        Set<KeyDefinition> keyDefinitions = new HashSet<>(keySet.size());
        for(KeyAdapter keyData : keySet) {
            String key = keyData.getKey().toLowerCase();
            KeyDefinition keyDefinition = computeKeyDefinition(key);
            if(keyDefinition != null) {
                switch (keyDefinition.getType()) {
                    case FEATURE: countPrimary++; break;
                    case SUBKEY: countValueSet++; break;
                    case NAMESPACE: countFreeValue++; break;
                }
                keyDefinitions.add(keyDefinition);
            } else {
                System.out.println("Invalid key: "+key);
            }
        }

        print("[Key stats]: ");
        printStatsValue("input keys", keySet.size());
        printStatsValue(" -> key definitions", keyDefinitions.size());
        printStatsValue(" (FEATURE", countPrimary);
        printStatsValue("; SUBKEY", countValueSet);
        printStatsValue("; NAMESPACE", countFreeValue);
        printLine(")");

        result.addKeysToSegment(segment, keyDefinitions);
    }

    private void computeValueDefinitions(KeySegment segment, Map<String, List<ValueAdapter>> keyValueMap,
                                         InterpretationResult result) {
        Set<String> valueDefinitions = new HashSet<>();
        int valueCount = 0;
        for(KeyDefinition keyDef : result.getKeySetOfSegment(segment)) {
            List<ValueAdapter> valuesForKey = keyValueMap.get(keyDef.getId());
            if(valuesForKey != null) {
                for (ValueAdapter valueData : valuesForKey) {
                    ++valueCount;
                    String value = valueData.getValue().toLowerCase();
                    if (isValueDefinable(value)) {
                        valueDefinitions.add(value);
                    }
                }
            }
        }

        print("[Value stats]: ");
        printStatsValue("input keys/values", keyValueMap.size());
        printStatsValue("/", valueCount);
        printStatsValue(" -> value definitions", valueDefinitions.size());
        printLine("");

        result.addValuesToSegment(segment, valueDefinitions);
    }

    private void computeValueMappings(KeySegment segment, Map<String, List<ValueAdapter>> keyValueMap,
                                      InterpretationResult result)
    {
        Map<String, Set<String>> mappings = new HashMap<>(keyValueMap.size());
        int mappingCount = 0, valueCount = 0;
        for(Map.Entry<String, List<ValueAdapter>> entry : keyValueMap.entrySet()) {
            if(isKeyDefinable(entry.getKey()) && result.getKeySetOfSegment(segment).contains(new KeyDefinition(entry.getKey()))) {
                Set<String> valueSet = new HashSet<>();
                for (ValueAdapter valueData : entry.getValue()) {
                    ++valueCount;
                    String value = valueData.getValue();
                    if (isValueDefinable(value) && result.getValueSetOfSegment(segment).contains(value)) {
                        valueSet.add(valueData.getValue());
                    }
                }
                if (!valueSet.isEmpty()) {
                    mappingCount += valueSet.size();
                    mappings.put(entry.getKey(), valueSet);
                }
            }
        }

        print("[Mapping stats]: ");
        printStatsValue("input keys/values", keyValueMap.size());
        printStatsValue("/", valueCount);
        printStatsValue(" -> mappings", mappingCount);
        printLine("");

        result.addKeyValueMappings(segment, mappings);
    }

    private boolean isKeyDefinable(String key) {
        return computeKeyDefinition(key) != null;
    }

    private KeyDefinition computeKeyDefinition(String key) {
        if(!key.matches(KEY_VALUE_FILTER))
            return null;

        Namespace ns = null;
        if(key.contains(":")) {
            String[] keyParts = key.split(":");
            if(keyParts.length > 2) {
                return null;
            }
            ns = Namespace.getByKey(keyParts[0]);
            if(ns == null) {
                return null;
            }
        }

        KeyDefinition.Type type;
        if (FeatureKeySet.get().contains(key)) {
            type = KeyDefinition.Type.FEATURE;
        } else if (Namespace.getByKey(key) != null) {
            type = KeyDefinition.Type.NAMESPACE;
        } else {
            type = KeyDefinition.Type.SUBKEY;
        }

        return new KeyDefinition(key, type, ns);
    }

    private boolean isValueDefinable(String value) {
        return (!value.isEmpty() && !StringUtils.isNumeric(value) &&
            value.matches(KEY_VALUE_FILTER));
    }

    private void printStatsHeader(String headline) {
        System.out.println("\n=== "+headline+" ===");
    }

    private void printLine(String line) {
        System.out.println(line);
    }

    private void print(String text) {
        System.out.print(text);
    }

    private void printStatsValue(String label, int value) {
        System.out.print(label + ": " + value);
    }
}
