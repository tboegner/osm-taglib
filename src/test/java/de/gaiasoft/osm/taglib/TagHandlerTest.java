package de.gaiasoft.osm.taglib;

import de.gaiasoft.osm.taglib.support.KeyInfo;
import de.gaiasoft.osm.taglib.support.TagHandler;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

class TagHandlerTest {
    @RepeatedTest(5)
    void testFindKeyPerformance(RepetitionInfo repInfo) {
        HashSet<String> keySet = new HashSet<>();
        keySet.add("aeroway");
//        keySet.add("ramp");
//        keySet.add("source");
//        keySet.add("water_well");

        for (String key: keySet) {
            StopWatch stopWatch = StopWatch.createStarted();
            KeyInfo keyInfo = TagHandler.getInstance().findKey(key);
            stopWatch.stop();
            long micros = stopWatch.getTime(TimeUnit.MICROSECONDS);
            System.out.println(String.format("findKey[%d] '%s' took %d micros",
                    repInfo.getCurrentRepetition(), key, micros));
        }
    }
}
