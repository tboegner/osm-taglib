package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
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
