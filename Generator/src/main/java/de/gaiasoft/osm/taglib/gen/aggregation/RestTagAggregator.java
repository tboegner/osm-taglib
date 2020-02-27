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
    private int pageSizeForKeyValue = 25;

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

    abstract Set<KeyAdapter> determineBasicKeySet();
    abstract Set<KeyAdapter> determineExtendedKeySet(Set<KeyAdapter> basicKeySet);


    private boolean isValueAccepted(KeyValuesData valueData) {
        boolean qualifiedByUsage = valueData.getFraction() > qualifierValueUsage;
        boolean disqualifiedByUsage =  valueData.getFraction() <= 0.0001;
        boolean disqualifiedByDescription = valueData.getDescription() == null || valueData.getDescription().isEmpty() || valueData.getDescription().equals("null");
        boolean notDisqualified = !(disqualifiedByUsage || disqualifiedByDescription);
        return (qualifiedByUsage || (valueData.getIn_wiki() && notDisqualified));
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
        writeKeyValueMappinsFile(valueMappings);
        return valueMappings;
    }

    private List<ValueAdapter> determineValuesForKey(String key) {
        List<ValueAdapter> valuesForKey = new ArrayList<>();
        KeyValues keyValues;
        int qualifiedOnPage, page=0;
        do {
            keyValues = tagInfo.getKeyValues(key, ++page, pageSizeForKeyValue, TagInfoRestClient.SORT_COUNT_ALL, false);

            qualifiedOnPage = 0;
            for (KeyValuesData item : keyValues.getData()) {
                if(isValueAccepted(item)) {
                    ++qualifiedOnPage;
                    valuesForKey.add(new ValueAdapter(item));
                }
            }
            System.out.println("Qualified on page: "+qualifiedOnPage);
        } while(keyValues.getData().size() == pageSizeForKeyValue && qualifiedOnPage > 0);
        return valuesForKey;
    }

    private void writeKeySetFile(Set<KeyAdapter> keySet) {
        try(CSVBuilder csvBuilder = new CSVBuilder("KeySet", getClass().getSimpleName())) {
            csvBuilder.buildKeySetHeader();
            for(KeyAdapter key : keySet) {
                csvBuilder.buildKeyRecord(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeKeyValueMappinsFile(Map<String, List<ValueAdapter>> keyValueMappings) {
        try(CSVBuilder csvBuilder = new CSVBuilder("KeyValueMap", getClass().getSimpleName())) {
            csvBuilder.buildKeyValueMapHeader();
            for(Map.Entry<String, List<ValueAdapter>> mapping : keyValueMappings.entrySet()) {
                for(ValueAdapter valueAdapter: mapping.getValue()) {
                    csvBuilder.buildValueRecord(mapping.getKey(), valueAdapter);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
