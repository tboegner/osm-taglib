package de.gaiasoft.osm.taglib;

import static de.gaiasoft.osm.taglib.TagKey.Type.*;

public enum TagKey {
    HISTORIC("historic", FEATURE),
    NATURAL("natural", FEATURE),
    MAN_MADE("man_made", FEATURE),
    WATERWAY("waterway", FEATURE),
    AERIALWAY("aerialway", FEATURE),
    VENDING("vending", SUBKEY),
    ROUTE("route", FEATURE),
    CRAFT("craft", FEATURE),
    SPORT("sport", FEATURE),
    AEROWAY("aeroway", FEATURE),
    SHOP("shop", FEATURE),
    GEOLOGICAL("geological", FEATURE),
    WHEELCHAIR("wheelchair", SUBKEY),
    BOUNDARY("boundary", FEATURE),
    AMENITY("amenity", FEATURE),
    EMERGENCY("emergency", FEATURE),
    TOURISM("tourism", FEATURE),
    BUILDING("building", FEATURE),
    PUBLIC_TRANSPORT("public_transport", FEATURE),
    OFFICE("office", FEATURE),
    BARRIER("barrier", FEATURE),
    PLACE("place", FEATURE),
    POWER("power", FEATURE),
    RAILWAY("railway", FEATURE),
    TELECOM("telecom", FEATURE),
    MILITARY("military", FEATURE),
    LEISURE("leisure", FEATURE),
    HIGHWAY("highway", FEATURE),
    ORGANIC("organic", SUBKEY),
    ;

    public enum Type {
        FEATURE,
        SUBKEY,
        NAMESPACE
        ;
    }


    public static TagKey findKey(String key) {
        for(TagKey tagKey : values()) {
            if(tagKey.key.equals(key) || (tagKey.shortKey != null && tagKey.shortKey.equals(key))) {
                return tagKey;
            }
        }
        return null;
    }

    private String key;
    private String shortKey = null;
    private Type type;
    TagKey(String key, Type type) {
        this(key, type, false);
    }
    TagKey(String key, Type type, boolean allowShortKey) {
        this.key = key;
        if(allowShortKey && key.contains(":")) {
            String[] keyParts = key.split(":");
            shortKey = keyParts[keyParts.length-1];
        }
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public Type getType() {
        return type;
    }

}
