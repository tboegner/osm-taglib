package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyValuesData;

public class ValueAdapter {
    public static class Qualification {
        public boolean accepted;
        public boolean disqualifiedByUsage;
        public boolean disqualifiedByMissingWiki;
        public boolean notDisqualified;
        public boolean qualifiedByUsage;
        public boolean qualifiedByWiki;
    }

    private KeyValuesData keyValuesData;
    private Qualification qualification;

    public ValueAdapter(KeyValuesData keyValuesData) {
        this.keyValuesData = keyValuesData;
    }

    public String getValue() {
        return keyValuesData.getValue();
    }

    public KeyValuesData getKeyValuesData() {
        return keyValuesData;
    }

    public Qualification getQualification() {
        if(qualification == null) {
            qualification = new Qualification();
        }
        return qualification;
    }
}
