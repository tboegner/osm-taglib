package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.ValueBase;

public enum Value_BUILDING implements ValueBase {
    SHED("shed"),
    COMMERCIAL("commercial"),
    HUT("hut"),
    UNIVERSITY("university"),
    CHURCH("church"),
    CABIN("cabin"),
    OFFICE("office"),
    HOUSE("house"),
    RETAIL("retail"),
    CIVIC("civic"),
    PUBLIC("public"),
    SCHOOL("school"),
    BARN("barn"),
    CONSTRUCTION("construction"),
    FARM("farm"),
    HOTEL("hotel"),
    TERRACE("terrace"),
    HOSPITAL("hospital"),
    ROOF("roof"),
    BUNGALOW("bungalow"),
    YES("yes"),
    SEMIDETACHED_HOUSE("semidetached_house"),
    GARAGE("garage"),
    GREENHOUSE("greenhouse"),
    WAREHOUSE("warehouse"),
    CHAPEL("chapel"),
    FARM_AUXILIARY("farm_auxiliary"),
    DETACHED("detached"),
    GARAGES("garages"),
    INDUSTRIAL("industrial"),
    RESIDENTIAL("residential"),
    SERVICE("service"),
    RUINS("ruins"),
    APARTMENTS("apartments"),
    STATIC_CARAVAN("static_caravan"),
    ;

    private String value;
    Value_BUILDING(String value) {
        this.value = value;
    }

    @Override
    public String getValue() { return value; }
}
