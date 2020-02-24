package de.gaiasoft.osm.taglib.gen.aggregation;

import de.gaiasoft.osm.taglib.rest.taginfo.TagInfoRestClient;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * A base class for strategies, which aggregate tag data via
 * the Taginfo REST interface. Determined key set and value mappings are written into csv-files.
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

    abstract Set<KeysAllData> determineBasicKeySet();
    abstract Set<KeysAllData> determineExtendedKeySet(Set<KeysAllData> basicKeySet);
    abstract String getPostfixIdentifier();


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

    private Set<KeysAllData> determineKeySet() {
        Set<KeysAllData> keySet = determineBasicKeySet();
        keySet.addAll(determineExtendedKeySet(keySet));
        writeKeySetFile(keySet);
        return keySet;
    }

    private Map<String, List<KeyValuesData>> determineValueMappings(Set<KeysAllData> keySet) {
        Map<String, List<KeyValuesData>> valueMappings = new HashMap<>();
        for(KeysAllData item: keySet) {
            valueMappings.put(item.getKey(), determineValuesForKey(item.getKey()));
        }
        writeKeyValueMappinsFile(valueMappings);
        return valueMappings;
    }

    private List<KeyValuesData> determineValuesForKey(String key) {
        List<KeyValuesData> valuesForKey = new ArrayList<>();
        KeyValues keyValues;
        int qualifiedOnPage, page=0;
        do {
            keyValues = tagInfo.getKeyValues(key, ++page, pageSizeForKeyValue, TagInfoRestClient.SORT_COUNT_ALL, false);

            qualifiedOnPage = 0;
            for (KeyValuesData item : keyValues.getData()) {
                if(isValueAccepted(item)) {
                    ++qualifiedOnPage;
                    valuesForKey.add(item);
                }
            }
            System.out.println("Qualified on page: "+qualifiedOnPage);
        } while(keyValues.getData().size() == pageSizeForKeyValue && qualifiedOnPage > 0);
        return valuesForKey;
    }

    // HINT: The functions should not do rest call "getStats" always. Instead
    // the caller could decide, if he needs stats data and do it optionally.
    // This also means, that the return value in our interfaces should be
    // decoupled. Instead of KeysAllData it should be a common usable format,
    // where e.g. stats data is optional.
    KeysAllData convertStatsToCommonFormat(String key, KeyStats keyStats) {
        KeysAllData keysAllData = new KeysAllData();
        keysAllData.setKey(key);
        for(KeyStatsData item: keyStats.getData()) {
            switch (item.getType()) {
                case "all":
                    keysAllData.setCount_all(item.getCount());
                    keysAllData.setCount_all_fraction(item.getCount_fraction());
                    break;
                case "nodes":
                    keysAllData.setCount_nodes(item.getCount());
                    keysAllData.setCount_nodes_fraction(item.getCount_fraction());
                    break;
                case "ways":
                    keysAllData.setCount_ways(item.getCount());
                    keysAllData.setCount_ways_fraction(item.getCount_fraction());
                    break;
                case "relations":
                    keysAllData.setCount_relations(item.getCount());
                    keysAllData.setCount_relations_fraction(item.getCount_fraction());
                    break;
            }
        }
        return keysAllData;
    }

    private void writeKeySetFile(Set<KeysAllData> keySet) {
        try(CSVPrinter csvPrinter = buildCSVPrinter("KeySet")) {
            csvPrinter.printRecord("Key",
                    "count_all", "count_all_fraction",
                    "count_nodes", "count_nodes_fraction",
                    "count_ways", "count_ways_fraction",
                    "count_relations", "count_relations_fraction");
            for(KeysAllData item : keySet) {
                csvPrinter.printRecord(item.getKey(),
                        item.getCount_all(), item.getCount_all_fraction(),
                        item.getCount_nodes(), item.getCount_nodes_fraction(),
                        item.getCount_ways(), item.getCount_ways_fraction(),
                        item.getCount_relations(), item.getCount_relations_fraction());
            }
            csvPrinter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeKeyValueMappinsFile(Map<String, List<KeyValuesData>> keyValueMappings) {
        try(CSVPrinter csvPrinter = buildCSVPrinter("KeyValueMap")) {
            csvPrinter.printRecord("key", "value",
                    "count", "fraction",
                    "in_wiki", "description");
            for(Map.Entry<String, List<KeyValuesData>> mapping : keyValueMappings.entrySet()) {
                for(KeyValuesData valueData: mapping.getValue()) {
                    csvPrinter.printRecord(mapping.getKey(), valueData.getValue(),
                            valueData.getCount(), valueData.getFraction(),
                            valueData.getIn_wiki(), valueData.getDescription());
                }
            }
            csvPrinter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CSVPrinter buildCSVPrinter(String baseFilename) throws IOException {
        FileWriter writer = new FileWriter(baseFilename+getPostfixIdentifier()+".csv");
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';').withRecordSeparator('\n');
        return new CSVPrinter(writer, format);
    }
}
