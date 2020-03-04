package de.gaiasoft.osm.taglib.gen.processing;

import de.gaiasoft.osm.taglib.gen.generation.KeyDefinition;

import java.util.*;

public class InterpretationResult {
    static class KeySegmentData {
        Set<KeyDefinition> keySet = new HashSet<>();
        Set<String> valueSet = new HashSet<>();
        Map<String, Set<String>> keyValueMappings = new HashMap<>();
    }

    private Map<KeySegment, KeySegmentData> segmentMap = new HashMap<>();

    public InterpretationResult() {
        for (KeySegment segment: KeySegment.values()) {
            segmentMap.put(segment, new KeySegmentData());
        }
    }

    void addKeysToSegment(KeySegment segment, Set<KeyDefinition> keySet) {
        segmentMap.get(segment).keySet.addAll(keySet);
    }

    void addValuesToSegment(KeySegment segment, Set<String> valueSet) {
        segmentMap.get(segment).valueSet.addAll(valueSet);
    }

    void addKeyValueMappings(KeySegment segment, Map<String, Set<String>> mappings) {
        segmentMap.get(segment).keyValueMappings.putAll(mappings);
    }

    public Set<KeyDefinition> getKeySetOfSegment(KeySegment segment) {
        return segmentMap.get(segment).keySet;
    }

    public Set<String> getValueSetOfSegment(KeySegment segment) {
        return segmentMap.get(segment).valueSet;
    }

    public Map<String, Set<String>> getKeyValueMappingsOfSegement(KeySegment segment) {
        return segmentMap.get(segment).keyValueMappings;
    }
}
