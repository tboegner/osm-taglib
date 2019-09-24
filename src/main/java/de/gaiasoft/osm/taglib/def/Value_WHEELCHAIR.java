package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_WHEELCHAIR implements ValueBase {
    NO("no"),
    LIMITED("limited"),
    YES("yes"),
    ;

    private String value;
    Value_WHEELCHAIR(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
