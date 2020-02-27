package de.gaiasoft.osm.taglib.gen.aggregation;

import java.util.*;

public class AggregationResult {
    public Set<KeyAdapter> keySet = new HashSet<>();
    public Map<String, List<ValueAdapter>> keyValueMappings = new HashMap<>();

    public Set<String> getSimpleKeySet() {
        Set<String> simpleKeySet = new HashSet<>(keySet.size());
        for (KeyAdapter keyData : keySet) {
            simpleKeySet.add(keyData.getKey());
        }
        return simpleKeySet;
    }
}
