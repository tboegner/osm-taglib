package de.gaiasoft.osm.taglib;

import de.gaiasoft.osm.taglib.support.KeyInfo;
import de.gaiasoft.osm.taglib.support.TagHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TagTest {
    private static Stream<Arguments> keyProvider() {
        return Stream.of(
                arguments("name"),
                arguments("description"),
                arguments("note"),
                arguments("source"),
                arguments("addr:country"),
                arguments("addr:city"),
                arguments("addr:suburb"),
                arguments("addr:place"),
                arguments("addr:street"),
                arguments("addr:housenumber"),
                arguments("addr:postcode"),
                arguments("contact:phone"),
                arguments("contact:fax"),
                arguments("contact:email"),
                arguments("contact:website"),
                arguments("produce"),
                arguments("operator"),
                arguments("opening_hours")
        );
    }

    private static Stream<Arguments> tagMappingProvider() {
        return Stream.of(
                arguments("shop", "bakery"),
                arguments("shop", "butcher"),
                arguments("shop", "farm"),
                arguments("shop", "greengrocer"),
                arguments("shop", "supermarket"),
                arguments("shop", "convenience"),
                arguments("shop", "beverages"),
                arguments("amenity", "vending_machine"),
                arguments("amenity", "marketplace"),
                arguments("amenity", "bar"),
                arguments("amenity", "cafe"),
                arguments("amenity", "biergarten"),
                arguments("amenity", "fast_food"),
                arguments("amenity", "food_court"),
                arguments("amenity", "ice_cream"),
                arguments("amenity", "pub"),
                arguments("amenity", "restaurant"),
                arguments("vending", "food"),
                arguments("vending", "cigarettes"),
                arguments("wheelchair", "yes"),
                arguments("wheelchair", "no"),
                arguments("wheelchair", "limited"),
                arguments("building", "yes"),
                arguments("organic", "yes"),
                arguments("organic", "no"),
                arguments("organic", "only")
        );
    }

    @ParameterizedTest
    @MethodSource("keyProvider")
    void testKeyExists(String key) {
        TagHandler tagHandler = TagHandler.getInstance();
        KeyInfo keyInfo = tagHandler.findKey(key);
        assertNotNull(keyInfo);
    }

    @ParameterizedTest
    @MethodSource("tagMappingProvider")
    void testMappingExists(String key, String value) {
        TagHandler tagHandler = TagHandler.getInstance();
        KeyInfo keyInfo = tagHandler.findKey(key);
        assertNotNull(keyInfo);

        boolean valueValidForKey = tagHandler.isValueValidForKey(key, value);
        assertTrue(valueValidForKey);
    }

}
