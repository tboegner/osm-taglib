package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_AEROWAY implements ValueBase {
    HANGAR("hangar"),
    FUEL("fuel"),
    RUNWAY("runway"),
    APRON("apron"),
    WINDSOCK("windsock"),
    TERMINAL("terminal"),
    HELIPORT("heliport"),
    TAXILANE("taxilane"),
    HOLDING_POSITION("holding_position"),
    PARKING_POSITION("parking_position"),
    AERODROME("aerodrome"),
    TAXIWAY("taxiway"),
    SPACEPORT("spaceport"),
    NAVIGATIONAID("navigationaid"),
    GATE("gate"),
    HELIPAD("helipad"),
    AIRSTRIP("airstrip"),
    ;

    private String value;
    Value_AEROWAY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
