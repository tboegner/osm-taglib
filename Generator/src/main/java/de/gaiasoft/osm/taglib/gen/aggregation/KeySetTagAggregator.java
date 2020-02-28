package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.gen.util.ConfigManager;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyStats;

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

    /**
     * Fetches stats of each key in the basic set.
     * @return Basic key set that was input enriched by usage stats.
     */
    @Override
    public Set<KeyAdapter> determineBasicKeySet() {
        Set<KeyAdapter> basicKeySet = new HashSet<>();
        boolean fetchKeyStats = ConfigManager.getInstance().getFetchKeyStats();
        for (String key : inputKeySet) {
            if(fetchKeyStats) {
                KeyStats keyStats = tagInfo.getKeyStats(key);
                basicKeySet.add(new KeyAdapter(key, keyStats));
            } else {
                basicKeySet.add(new KeyAdapter(key));
            }
        }
        return basicKeySet;
    }

    /**
     * No extended key set is determined by this class.
     * @param basicKeySet ignored.
     * @return Empty hash set.
     */
    @Override
    public Set<KeyAdapter> determineExtendedKeySet(Set<KeyAdapter> basicKeySet) {
        return new HashSet<>();
    }
}
