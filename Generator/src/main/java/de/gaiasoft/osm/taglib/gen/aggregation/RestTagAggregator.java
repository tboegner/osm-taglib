package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.gen.util.CSVBuilder;
import de.gaiasoft.osm.taglib.rest.taginfo.TagInfoRestClient;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyValues;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyValuesData;

import java.io.IOException;
import java.util.*;

/**
 * A base class for strategies, which aggregate tag data via
 * the Taginfo REST interface. The logic for determining the values belonging to a key is implemented here.
 * Determined key set and value mappings are written into csv-files.
 */
public abstract class RestTagAggregator implements TagAggregatorStrategy {
    private double qualifierValueUsage = 0.05;
    private double disqualifierValueUsage = 0.0001;
    private int pageSizeForKeyValue = 25;
    private boolean valueMustBeInWiki = false;

    TagInfoRestClient tagInfo;

    RestTagAggregator() {
        tagInfo = new TagInfoRestClient();
    }

    public RestTagAggregator withPageSizeForKeyValue(int pageSize) {
        this.pageSizeForKeyValue = pageSize;
        return this;
    }

    public RestTagAggregator withQualifierValueUsage(double qualifier) {
        this.qualifierValueUsage = qualifier;
        return this;
    }

    public RestTagAggregator withDisqualifierValueUsage(double disqualifier) {
        this.disqualifierValueUsage = disqualifier;
        return this;
    }

    public RestTagAggregator withValueMustBeInWiki(boolean inWiki) {
        this.valueMustBeInWiki = inWiki;
        return this;
    }

    abstract Set<KeyAdapter> determineBasicKeySet();
    abstract Set<KeyAdapter> determineExtendedKeySet(Set<KeyAdapter> basicKeySet);


    private boolean isValueAccepted(ValueAdapter valueAdapter) {
        KeyValuesData valueData = valueAdapter.getKeyValuesData();
        ValueAdapter.Qualification q = valueAdapter.getQualification();

        q.disqualifiedByUsage =  valueData.getFraction() <= disqualifierValueUsage;
        q.disqualifiedByMissingWiki = valueMustBeInWiki && !valueData.getIn_wiki();
        q.notDisqualified = !(q.disqualifiedByUsage || q.disqualifiedByMissingWiki);

        q.qualifiedByUsage = valueData.getFraction() > qualifierValueUsage;
        q.qualifiedByWiki = valueData.getIn_wiki() && valueData.getDescription() != null &&
                !valueData.getDescription().isEmpty() && !valueData.getDescription().equals("null");

        q.accepted = q.notDisqualified && (q.qualifiedByUsage || q.qualifiedByWiki);
        return q.accepted;
    }

    @Override
    public AggregationResult aggregateTagData() {
        AggregationResult result = new AggregationResult();
        result.keySet = determineKeySet();
        result.keyValueMappings = determineValueMappings(result.keySet);
        return result;
    }

    private Set<KeyAdapter> determineKeySet() {
        Set<KeyAdapter> keySet = determineBasicKeySet();
        keySet.addAll(determineExtendedKeySet(keySet));
        writeKeySetFile(keySet);
        return keySet;
    }

    private Map<String, List<ValueAdapter>> determineValueMappings(Set<KeyAdapter> keySet) {
        Map<String, List<ValueAdapter>> valueMappings = new HashMap<>();
        for(KeyAdapter item: keySet) {
            valueMappings.put(item.getKey(), determineValuesForKey(item.getKey()));
        }
        return valueMappings;
    }

    private List<ValueAdapter> determineValuesForKey(String key) {
        List<ValueAdapter> valuesForKey = new ArrayList<>();
        KeyValues keyValues;
        int qualifiedOnPage, page=0;
        boolean notUsageLimitReached = true;
        CSVBuilder restLogger = new CSVBuilder(CSVBuilder.Type.REST_CALL, getClass().getSimpleName());
        CSVBuilder keyValueLogger = new CSVBuilder(CSVBuilder.Type.KEY_VALUE_MAP, getClass().getSimpleName());
        do {
            keyValues = tagInfo.getKeyValues(key, ++page, pageSizeForKeyValue, TagInfoRestClient.SORT_COUNT_ALL, false);

            qualifiedOnPage = 0;
            for (KeyValuesData item : keyValues.getData()) {
                ValueAdapter value = new ValueAdapter(item);
                if (isValueAccepted(value)) {
                    ++qualifiedOnPage;
                    valuesForKey.add(value);
                }
                keyValueLogger.buildValueRecord(key, value);
                notUsageLimitReached = !value.getQualification().disqualifiedByUsage;
            }
            restLogger.buildRestCallRecord(new CSVBuilder.RestData(key, page, pageSizeForKeyValue, keyValues.getTotal(), keyValues.getData().size(), qualifiedOnPage));
        } while (keyValues.getData().size() == pageSizeForKeyValue && notUsageLimitReached && qualifiedOnPage > 0);

        restLogger.close();
        keyValueLogger.close();
        return valuesForKey;
    }

    private void writeKeySetFile(Set<KeyAdapter> keySet) {
        try(CSVBuilder csvBuilder = new CSVBuilder(CSVBuilder.Type.KEY_SET, getClass().getSimpleName())) {
            for(KeyAdapter key : keySet) {
                csvBuilder.buildKeyRecord(key);
            }
        }
    }
}
