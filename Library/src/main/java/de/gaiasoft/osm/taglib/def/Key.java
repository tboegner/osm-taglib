package de.gaiasoft.osm.taglib.def;

import de.gaiasoft.osm.taglib.base.KeyBase;

/*  This file is auto-generated.
    The values of the enum are extracted from OpenStreetMap data. Therefore this enum is considered to be something
    database-like and its values are made available under the Open Database License:
    http://opendatacommons.org/licenses/odbl/1.0/.
*/
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
    EMERGENCY("emergency"),
    TOURISM("tourism"),
    BUILDING("building"),
    PUBLIC_TRANSPORT("public_transport"),
    OFFICE("office"),
    BARRIER("barrier"),
    RAILWAY("railway"),
    PLACE("place"),
    POWER("power"),
    TELECOM("telecom"),
    MILITARY("military"),
    LEISURE("leisure"),
    HIGHWAY("highway"),
    LANDUSE("landuse"),
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
    ADDR_STREET("addr:street"),
    ADDR_PLACE("addr:place"),
    ADDR_INTERPOLATION("addr:interpolation"),
    OFFICIAL_NAME("official_name"),
    SORTING_NAME("sorting_name"),
    INT_NAME("int_name"),
    ALT_NAME("alt_name"),
    OLD_NAME("old_name"),
    NAT_NAME("nat_name"),
    REG_NAME("reg_name"),
    LOC_NAME("loc_name"),
    NAME("name"),
    SHORT_NAME("short_name"),
    CONTACT_FAX("contact:fax"),
    NOTE("note"),
    CONTACT_PHONE("contact:phone"),
    SOURCE("source"),
    DESCRIPTION("description"),
    CONTACT_EMAIL("contact:email"),
    CONTACT_WEBSITE("contact:website"),
    PRODUCE("produce"),
    WHEELCHAIR("wheelchair"),
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
