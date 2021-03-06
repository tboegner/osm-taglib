package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.rest.taginfo.TagInfoRestClient;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Finds keys via the "keysAll"-interface. Relevance is determined by absolute
 * appearance of a key.
 */
public class AllKeysTagAggregator extends RestTagAggregator {
    private int pageSizeAllKeys = 100;
    private double qualifierKeyUsage = 0.0001;

    @Override
    public Set<KeyAdapter> determineBasicKeySet() {
        Set<KeyAdapter> basicKeySet = new HashSet<>();
        KeysAll keysAll;
        int page=0;
        boolean fetchNextPage = true;
        do {
            keysAll = tagInfo.getKeysAll(++page, pageSizeAllKeys, TagInfoRestClient.FILTER_IN_WIKI, TagInfoRestClient.SORT_COUNT_ALL, false);
            for (KeysAllData item : keysAll.getData()) {
                if(item.getCount_all_fraction() > qualifierKeyUsage) {
                    basicKeySet.add(new KeyAdapter(item));
                } else {
                    fetchNextPage = false;
                    break;
                }
            }
        } while (fetchNextPage && (page * pageSizeAllKeys < keysAll.getTotal()));
        return basicKeySet;
    }

    @Override
    public Set<KeyAdapter> determineExtendedKeySet(Set<KeyAdapter> basicKeySet) {
        return new HashSet<>();
    }
}
