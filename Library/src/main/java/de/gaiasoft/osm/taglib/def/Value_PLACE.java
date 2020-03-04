package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
public enum Value_PLACE implements ValueBase {
    ISOLATED_DWELLING("isolated_dwelling"),
    TOWN("town"),
    HAMLET("hamlet"),
    CITY("city"),
    ISLAND("island"),
    LOCALITY("locality"),
    ALLOTMENTS("allotments"),
    COUNTY("county"),
    MUNICIPALITY("municipality"),
    BOROUGH("borough"),
    ISLET("islet"),
    SQUARE("square"),
    PLOT("plot"),
    NEIGHBOURHOOD("neighbourhood"),
    DISTRICT("district"),
    SUBURB("suburb"),
    FARM("farm"),
    ARCHIPELAGO("archipelago"),
    STATE("state"),
    VILLAGE("village"),
    REGION("region"),
    CITY_BLOCK("city_block"),
    QUARTER("quarter"),
    ;

    private String value;
    Value_PLACE(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
