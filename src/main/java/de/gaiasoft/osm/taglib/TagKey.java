package de.gaiasoft.osm.taglib;

import java.util.*;

public enum TagKey {
    AMENITY("amenity", Status.TYPE),
    SHOP("shop", Status.TYPE),
    NAME("name", Status.FREE_VALUE),
    DESCRIPTION("description", Status.FREE_VALUE),
    NOTE("note", Status.FREE_VALUE),
    SOURCE("source", Status.FREE_VALUE),
    ADDR_COUNTRY("addr:country", Status.FREE_VALUE, true),
    ADDR_CITY("addr:city", Status.FREE_VALUE, true),
    ADDR_SUBURB("addr:suburb", Status.FREE_VALUE, true),
    ADDR_PLACE("addr:place", Status.FREE_VALUE, true),
    ADDR_STREET("addr:street", Status.FREE_VALUE, true),
    ADDR_HOUSE_NR("addr:housenumber", Status.FREE_VALUE, true),
    ADDR_POSTCODE("addr:postcode", Status.FREE_VALUE, true),
    CONTACT_PHONE("contact:phone", Status.FREE_VALUE, true),
    CONTACT_FAX("contact:fax", Status.FREE_VALUE, true),
    CONTACT_EMAIL("contact:email", Status.FREE_VALUE, true),
    CONTACT_WEBSITE("contact:website", Status.FREE_VALUE, true),
    OPEN_HRS("opening_hours", Status.FREE_VALUE),
    OPERATOR("operator", Status.FREE_VALUE),
    PRODUCT("product", Status.FREE_VALUE),
    PRODUCE("produce", Status.FREE_VALUE),
    WHEELCHAIR("wheelchair", Status.VALUE_SET),
    BUILDING("building", Status.VALUE_SET),
    ORGANIC("organic", Status.VALUE_SET),
    VENDING("vending", Status.VALUE_SET),
    ;

    public enum Status {
        TYPE,
        VALUE_SET,
        FREE_VALUE
        ;
        public boolean isValueLimited() {
            return this == TYPE || this == VALUE_SET;
        }
    }

    static Map<TagKey, Set<TagValue>> knownValueMap = new HashMap<>();
    private static void defineKnownValues(TagKey tagKey, TagValue[] values) {
        Set<TagValue> valueSet = new HashSet<>(values.length);
        valueSet.addAll(Arrays.asList(values));
        knownValueMap.put(tagKey, valueSet);
    }
    static {
        defineKnownValues(SHOP, new TagValue[] {
                TagValue.BAKERY,
                TagValue.BEVERAGES,
                TagValue.BUTCHER,
                TagValue.CONVENIENCE,
                TagValue.FARM,
                TagValue.GREENGROCER,
                TagValue.SUPERMARKET
        });
        defineKnownValues(AMENITY, new TagValue[] {
                TagValue.BAR,
                TagValue.BIERGARTEN,
                TagValue.CAFE,
                TagValue.FAST_FOOD,
                TagValue.FOOD_COURT,
                TagValue.ICE_CREAM,
                TagValue.MARKETPLACE,
                TagValue.PUB,
                TagValue.RESTAURANT,
                TagValue.VENDING_MACHINE
        });
        defineKnownValues(VENDING, new TagValue[] {
                TagValue.CIGARETTES,
                TagValue.FOOD
        });
        defineKnownValues(WHEELCHAIR, new TagValue[] {
                TagValue.DESIGNATED,
                TagValue.LIMITED,
                TagValue.NO,
                TagValue.YES
        });
        defineKnownValues(BUILDING, new TagValue[] {
                TagValue.NO,
                TagValue.YES
        });
        defineKnownValues(ORGANIC, new TagValue[] {
                TagValue.NO,
                TagValue.ONLY,
                TagValue.YES
        });
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
    private Status status;
    TagKey(String key, Status status) {
        this(key, status, false);
    }
    TagKey(String key, Status status, boolean allowShortKey) {
        this.key = key;
        if(allowShortKey && key.contains(":")) {
            String[] keyParts = key.split(":");
            shortKey = keyParts[keyParts.length-1];
        }
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isValueOk(TagValue value) {
        return status == Status.FREE_VALUE || knownValueMap.get(this).contains(value);
    }
}
