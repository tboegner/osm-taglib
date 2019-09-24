package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_OPERATOR implements ValueBase {
    CAMBIO("cambio"),
    INDEPENDENT("independent"),
    STADTMOBIL("stadtmobil"),
    ;

    private String value;
    Value_OPERATOR(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
