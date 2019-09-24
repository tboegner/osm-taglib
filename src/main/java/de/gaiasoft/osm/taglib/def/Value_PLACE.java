package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_PLACE implements ValueBase {
    CONTINENT("continent"),
    COUNTRY("country"),
    ISOLATED_DWELLING("isolated_dwelling"),
    CITY("city"),
    HAMLET("hamlet"),
    COUNTY("county"),
    MUNICIPALITY("municipality"),
    BOROUGH("borough"),
    CIVIL_PARISH("civil_parish"),
    ISLET("islet"),
    SEA("sea"),
    ATOLL("atoll"),
    PROVINCE("province"),
    PLOT("plot"),
    NEIGHBOURHOOD("neighbourhood"),
    FARM("farm"),
    STATE("state"),
    VILLAGE("village"),
    AREA("area"),
    TOWN("town"),
    ISLAND("island"),
    ALLOTMENTS("allotments"),
    LOCALITY("locality"),
    PENINSULA("peninsula"),
    SQUARE("square"),
    OCEAN("ocean"),
    POWIAT("powiat"),
    DISTRICT("district"),
    ARCHIPELAGO("archipelago"),
    SHIELING("shieling"),
    SUBURB("suburb"),
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
