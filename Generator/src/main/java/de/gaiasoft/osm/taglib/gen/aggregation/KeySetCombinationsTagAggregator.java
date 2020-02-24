package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.rest.taginfo.TagInfoRestClient;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.*;

import java.util.HashSet;
import java.util.Set;

/**
 * The strategy takes a key set as input. Depending on this set further
 * keys are determined, which occur in combination with the basic keys.
 */
public class KeySetCombinationsTagAggregator extends KeySetTagAggregator {
    private int pageSizeCombinations = 20;
    private double qualifierCombinations = 0.05;

    public KeySetCombinationsTagAggregator(Set<String> inputKeySet) {
        super(inputKeySet);
    }

    @Override
    public String getPostfixIdentifier() {
        return "KeySetCombinations";
    }


    /**
     * Finds further keys, that occur in combination with the basic keys. For
     * each key the stats are queried. For determining relevance of a key the
     * "to_fraction" field is evaluated for a minimum value.
     * @param basicKeySet Basic keys to be analyzed for combinations.
     * @return Found keys that occur in combinations with basic keys.
     */
    @Override
    public Set<KeysAllData> determineExtendedKeySet(Set<KeysAllData> basicKeySet) {
        Set<KeysAllData> extendedKeySet = new HashSet<>();
        Set<String> qualifiedKeys = new HashSet<>();
        boolean fetchNextPage = true;
        for(KeysAllData basicKeyData : basicKeySet) {
            int page = 0;
            KeyCombinations keyCombinations;
            do {
                keyCombinations = tagInfo.getKeyCombinations(basicKeyData.getKey(), ++page, pageSizeCombinations, TagInfoRestClient.FILTER_ALL, TagInfoRestClient.SORT_TOGETHER_COUNT, false);
                for (KeyCombinationsData item : keyCombinations.getData()) {
                    if (item.getTo_fraction() > qualifierCombinations) {
                        if(!qualifiedKeys.contains(item.getOther_key())) {
                            KeyStats keyStats = tagInfo.getKeyStats(item.getOther_key());
                            extendedKeySet.add(convertStatsToCommonFormat(item.getOther_key(), keyStats));
                            qualifiedKeys.add(item.getOther_key());
                        }
                    } else {
                        fetchNextPage = false;
                        break; // leave for loop
                    }
                }
            } while(fetchNextPage && (page * pageSizeCombinations < keyCombinations.getTotal()));
        }
        return extendedKeySet;
    }
}
