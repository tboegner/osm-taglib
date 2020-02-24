package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_ORGANIC implements ValueBase {
    NO("no"),
    YES("yes"),
    ONLY("only"),
    ;

    private String value;
    Value_ORGANIC(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
