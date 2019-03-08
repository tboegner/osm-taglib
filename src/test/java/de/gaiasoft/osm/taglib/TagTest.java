package de.gaiasoft.osm.taglib;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TagTest {
    private static Stream<Arguments> tagMappingProvider() {
        return Stream.of(
                arguments("SHOP", "BAKERY"),
                arguments("SHOP", "BUTCHER"),
                arguments("SHOP", "FARM"),
                arguments("SHOP", "GREENGROCER"),
                arguments("SHOP", "SUPERMARKET"),
                arguments("SHOP", "CONVENIENCE"),
                arguments("SHOP", "BEVERAGES"),
                arguments("AMENITY", "VENDING_MACHINE"),
                arguments("AMENITY", "MARKETPLACE"),
                arguments("AMENITY", "BAR"),
                arguments("AMENITY", "CAFE"),
                arguments("AMENITY", "BIERGARTEN"),
                arguments("AMENITY", "FAST_FOOD"),
                arguments("AMENITY", "FOOD_COURT"),
                arguments("AMENITY", "ICE_CREAM"),
                arguments("AMENITY", "PUB"),
                arguments("AMENITY", "RESTAURANT"),
                arguments("VENDING", "FOOD"),
                arguments("VENDING", "CIGARETTES"),
                arguments("WHEELCHAIR", "YES"),
                arguments("WHEELCHAIR", "NO"),
                arguments("WHEELCHAIR", "LIMITED"),
                arguments("WHEELCHAIR", "DESIGNATED"),
                arguments("BUILDING", "YES"),
                arguments("BUILDING", "NO"),
                arguments("ORGANIC", "YES"),
                arguments("ORGANIC", "NO"),
                arguments("ORGANIC", "ONLY")
        );
    }

    @ParameterizedTest
    @MethodSource("tagMappingProvider")
    void testMappingExists(String key, String value) {
        TagKey tagKey = TagKey.valueOf(key);
        TagValue tagValue = TagValue.valueOf(value);

        Set<TagValue> tagValueSet = TagKeyKnownValueMap.instance().get(tagKey);
        assertNotNull(tagValueSet);

        assertTrue(tagValueSet.contains(tagValue));
    }

    @RepeatedTest(5)
    void testFindKeyPerformance(RepetitionInfo repInfo) {
        HashSet<String> keySet = new HashSet<>();
        keySet.add("aeroway");
        keySet.add("ramp");
        keySet.add("source");
        keySet.add("water_well");

        for (String key: keySet) {
            StopWatch stopWatch = StopWatch.createStarted();
            TagKey water_well = TagKey.findKey(key);
            stopWatch.stop();
            long micros = stopWatch.getTime(TimeUnit.MICROSECONDS);
            System.out.println(String.format("findKey[%d] '%s' took %d micros",
                    repInfo.getCurrentRepetition(), key, micros));
        }
    }
}
