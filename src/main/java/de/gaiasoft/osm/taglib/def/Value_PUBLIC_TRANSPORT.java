package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_PUBLIC_TRANSPORT implements ValueBase {
    PAY_SCALE_AREA("pay_scale_area"),
    STATION("station"),
    STOP_AREA("stop_area"),
    STOP_POSITION("stop_position"),
    POLE("pole"),
    PLATFORM("platform"),
    STOP_AREA_GROUP("stop_area_group"),
    ;

    private String value;
    Value_PUBLIC_TRANSPORT(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
