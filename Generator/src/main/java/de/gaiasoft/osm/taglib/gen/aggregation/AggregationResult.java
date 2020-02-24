package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyValuesData;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeysAllData;

import java.util.*;

public class AggregationResult {
    public Set<KeysAllData> keySet = new HashSet<>();
    public Map<String, List<KeyValuesData>> keyValueMappings = new HashMap<>();

    public Set<String> getSimpleKeySet() {
        Set<String> simpleKeySet = new HashSet<>(keySet.size());
        for (KeysAllData keyData : keySet) {
            simpleKeySet.add(keyData.getKey());
        }
        return simpleKeySet;
    }
}
