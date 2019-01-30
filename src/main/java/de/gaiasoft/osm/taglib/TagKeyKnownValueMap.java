package de.gaiasoft.osm.taglib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static de.gaiasoft.osm.taglib.TagKey.*;
import static de.gaiasoft.osm.taglib.TagValue.*;

public class TagKeyKnownValueMap extends HashMap<TagKey, Set<TagValue>> {
    private static TagKeyKnownValueMap instance = new TagKeyKnownValueMap();

    public static TagKeyKnownValueMap instance() {
        return instance;
    }

    private TagKeyKnownValueMap() {
        defineKnownValues(SHOP, new TagValue[] {
                BAKERY,
                BEVERAGES,
                BUTCHER,
                CONVENIENCE,
                FARM,
                GREENGROCER,
                SUPERMARKET
        });
        defineKnownValues(AMENITY, new TagValue[] {
                BAR,
                BIERGARTEN,
                CAFE,
                FAST_FOOD,
                FOOD_COURT,
                ICE_CREAM,
                MARKETPLACE,
                PUB,
                RESTAURANT,
                VENDING_MACHINE
        });
        defineKnownValues(TagKey.VENDING, new TagValue[] {
                CIGARETTES,
                FOOD
        });
        defineKnownValues(WHEELCHAIR, new TagValue[] {
                DESIGNATED,
                LIMITED,
                NO,
                YES
        });
        defineKnownValues(BUILDING, new TagValue[] {
                NO,
                YES
        });
        defineKnownValues(ORGANIC, new TagValue[] {
                NO,
                ONLY,
                YES
        });
    }

    private void defineKnownValues(TagKey tagKey, TagValue[] values) {
        Set<TagValue> valueSet = new HashSet<>(values.length);
        valueSet.addAll(Arrays.asList(values));
        put(tagKey, valueSet);
    }
}
