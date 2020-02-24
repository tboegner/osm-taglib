package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.rest.taginfo.TagInfoRestClient;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyCombinations;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyCombinationsData;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyStats;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeysAllData;

import java.util.HashSet;
import java.util.Set;

/**
 * The strategy takes a key set as input. For this keys the value mappings are determined.
 */
public class KeySetTagAggregator extends RestTagAggregator {
    private Set<String> inputKeySet;

    public KeySetTagAggregator(Set<String> inputKeySet) {
        this.inputKeySet = inputKeySet;
    }

    @Override
    public String getPostfixIdentifier() {
        return "KeySet";
    }

    /**
     * Fetches stats of each key in the basic set.
     * @return Basic key set that was input enriched by usage stats.
     */
    @Override
    public Set<KeysAllData> determineBasicKeySet() {
        Set<KeysAllData> basicKeySet = new HashSet<>();
        for (String key : inputKeySet) {
            KeyStats keyStats = tagInfo.getKeyStats(key);
            basicKeySet.add(convertStatsToCommonFormat(key, keyStats));
        }
        return basicKeySet;
    }

    /**
     * No extended key set is determined by this class.
     * @param basicKeySet ignored.
     * @return Empty hash set.
     */
    @Override
    public Set<KeysAllData> determineExtendedKeySet(Set<KeysAllData> basicKeySet) {
        return new HashSet<>();
    }
}
