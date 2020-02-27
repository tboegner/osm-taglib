package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyValuesData;

public class ValueAdapter {
    private KeyValuesData keyValuesData;

    public ValueAdapter(KeyValuesData keyValuesData) {
        this.keyValuesData = keyValuesData;
    }

    public String getValue() {
        return keyValuesData.getValue();
    }

    public KeyValuesData getKeyValuesData() {
        return keyValuesData;
    }
}
