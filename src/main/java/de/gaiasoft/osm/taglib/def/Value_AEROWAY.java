package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_AEROWAY implements ValueBase {
    HANGAR("hangar"),
    LAUNCHPAD("launchpad"),
    FUEL("fuel"),
    APRON("apron"),
    RUNWAY("runway"),
    HIGHWAY_STRIP("highway_strip"),
    WINDSOCK("windsock"),
    TERMINAL("terminal"),
    HELIPORT("heliport"),
    TAXILANE("taxilane"),
    AIRPORT("airport"),
    HOLDING_POSITION("holding_position"),
    PARKING_POSITION("parking_position"),
    AERODROME("aerodrome"),
    MARKING("marking"),
    TAXIWAY("taxiway"),
    SPACEPORT("spaceport"),
    NAVIGATIONAID("navigationaid"),
    LANDINGPAD("landingpad"),
    GATE("gate"),
    AIRSTRIP("airstrip"),
    HELIPAD("helipad"),
    ;

    private String value;
    Value_AEROWAY(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
