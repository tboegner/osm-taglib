package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.KeyBase;

public enum Key implements KeyBase {
    HISTORIC("historic"),
    NATURAL("natural"),
    MAN_MADE("man_made"),
    WATERWAY("waterway"),
    AERIALWAY("aerialway"),
    ROUTE("route"),
    CRAFT("craft"),
    SPORT("sport"),
    AEROWAY("aeroway"),
    SHOP("shop"),
    GEOLOGICAL("geological"),
    BOUNDARY("boundary"),
    AMENITY("amenity"),
    TOURISM("tourism"),
    EMERGENCY("emergency"),
    BUILDING("building"),
    PUBLIC_TRANSPORT("public_transport"),
    OFFICE("office"),
    BARRIER("barrier"),
    PLACE("place"),
    RAILWAY("railway"),
    POWER("power"),
    TELECOM("telecom"),
    MILITARY("military"),
    LEISURE("leisure"),
    HIGHWAY("highway"),
    ADDR_HOUSENAME("addr:housename"),
    ADDR_PROVINCE("addr:province"),
    ADDR_CONSCRIPTIONNUMBER("addr:conscriptionnumber"),
    ADDR_FLATS("addr:flats"),
    ADDR_COUNTRY("addr:country"),
    ADDR_CITY("addr:city"),
    ADDR_STATE("addr:state"),
    ADDR_SUBDISTRICT("addr:subdistrict"),
    ADDR_FULL("addr:full"),
    ADDR_HAMLET("addr:hamlet"),
    ADDR_HOUSENUMBER("addr:housenumber"),
    ADDR_POSTCODE("addr:postcode"),
    ADDR_SUBURB("addr:suburb"),
    ADDR_INCLUSION("addr:inclusion"),
    ADDR_DISTRICT("addr:district"),
    ADDR_PLACE("addr:place"),
    ADDR_STREET("addr:street"),
    ADDR_INTERPOLATION("addr:interpolation"),
    OFFICIAL_NAME("official_name"),
    SORTING_NAME("sorting_name"),
    ALT_NAME("alt_name"),
    INT_NAME("int_name"),
    OLD_NAME("old_name"),
    NAT_NAME("nat_name"),
    NAME("name"),
    LOC_NAME("loc_name"),
    REG_NAME("reg_name"),
    SHORT_NAME("short_name"),
    CONTACT_FAX("contact:fax"),
    NOTE("note"),
    CONTACT_PHONE("contact:phone"),
    SOURCE("source"),
    DESCRIPTION("description"),
    CONTACT_EMAIL("contact:email"),
    CONTACT_WEBSITE("contact:website"),
    WHEELCHAIR("wheelchair"),
    PRODUCE("produce"),
    OPENING_HOURS("opening_hours"),
    OPERATOR("operator"),
    VENDING("vending"),
    ORGANIC("organic"),
    ;

    private String key;

    Key(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

}
