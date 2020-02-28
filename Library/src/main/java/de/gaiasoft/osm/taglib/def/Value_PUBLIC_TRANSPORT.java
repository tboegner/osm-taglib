package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_PUBLIC_TRANSPORT implements ValueBase {
    STATION("station"),
    STOP_POSITION("stop_position"),
    STOP_AREA("stop_area"),
    POLE("pole"),
    PLATFORM("platform"),
    ;

    private String value;
    Value_PUBLIC_TRANSPORT(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
