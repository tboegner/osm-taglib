package de.gaiasoft.osm.taglib;

import de.gaiasoft.osm.taglib.def.Key;
import de.gaiasoft.osm.taglib.def.Value_AMENITY;
import de.gaiasoft.osm.taglib.def.Value_LANDUSE;
import de.gaiasoft.osm.taglib.support.Tag;
import de.gaiasoft.osm.taglib.support.TagHandler;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TagHandlerTest {
    @RepeatedTest(5)
    void findKeyPerformance(RepetitionInfo repInfo) {
        HashSet<String> keySet = new HashSet<>();
        keySet.add("aeroway");
        keySet.add("opening_hours");
        keySet.add("contact:website");
        keySet.add("natural");

        for (String key: keySet) {
            StopWatch stopWatch = StopWatch.createStarted();
            tagHandler().findKey(key);
            stopWatch.stop();
            long micros = stopWatch.getTime(TimeUnit.MICROSECONDS);
            System.out.println(String.format("findKey[%d] '%s' took %d micros",
                    repInfo.getCurrentRepetition(), key, micros));
            assertTrue(micros < 50000);
        }
    }

    @Test
    void landuseNotSupportsFreeValues() {
        assertFalse(tagHandler().isKeySupportingFreeValues("landuse"));
    }

    @Test
    void openingHoursSupportsFreeValues() {
        assertTrue(tagHandler().isKeySupportingFreeValues("opening_hours"));
    }

    @Test
    void invalidValueForKeyLanduse() {
        assertNull(tagHandler().findValidValueForKey("landuse", "terraforming"));
    }

    @Test
    void validValueForKeyLanduse() {
        assertEquals(Value_LANDUSE.RESIDENTIAL, tagHandler().findValidValueForKey("landuse", "residential"));
    }

    @Test
    void buildTagValid() {
        Tag expectedTag = new Tag(Key.AMENITY, Value_AMENITY.RESTAURANT);
        assertEquals(expectedTag, tagHandler().buildTag("amenity", "restaurant"));
    }

    @Test
    void buildTagInvalidValue() {
        assertNull(tagHandler().buildTag(Key.AMENITY, "space_bar"));
    }

    @Test
    void buildTagInvalidKey() {
        assertNull(tagHandler().buildTag("orbit", "bar"));
    }

    private TagHandler tagHandler() {
        return TagHandler.getInstance();
    }
}
