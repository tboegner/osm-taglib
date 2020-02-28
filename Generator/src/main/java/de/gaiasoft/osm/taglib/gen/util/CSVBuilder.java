package de.gaiasoft.osm.taglib.gen.util;

import de.gaiasoft.osm.taglib.gen.aggregation.KeyAdapter;
import de.gaiasoft.osm.taglib.gen.aggregation.ValueAdapter;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeyValuesData;
import de.gaiasoft.osm.taglib.rest.taginfo.bean.KeysAllData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CSVBuilder implements AutoCloseable {
    public enum Type {
        KEY_SET("KeySet", new Object[]{"key", "count_all", "count_all_fraction", "count_nodes", "count_nodes_fraction",
                "count_ways", "count_ways_fraction", "count_relations", "count_relations_fraction"}),
        KEY_VALUE_MAP("KeyValueMap", new Object[]{"key", "value", "count", "fraction", "in_wiki", "description"}),
        REST_CALL("RestCall", new Object[]{"key", "page", "pageSize", "total", "results", "qualifiedItems"});
        String id;
        Object[] header;
        Type(String id, Object[] header) {
            this.id = id;
            this.header = header;
        }
    }

    public static class RestData {
        String key;
        Integer page;
        Integer pageSize;
        Long total;
        Integer results;
        Integer qualifiedItems;

        public RestData(String key, Integer page, Integer pageSize, Long total, Integer results, Integer qualifiedItems) {
            this.key = key;
            this.page = page;
            this.pageSize = pageSize;
            this.total = total;
            this.results = results;
            this.qualifiedItems = qualifiedItems;
        }

        Object[] asObjectArray() {
            return new Object[]{key, page, pageSize, total, results, qualifiedItems};
        }
    }

    private static Set<String> filesForAppendMode = new HashSet<>();
    private CSVPrinter csvPrinter;

    public CSVBuilder(Type csvType, String simpleClassName) {
        String fileName = ConfigManager.getInstance().getLogDir() + csvType.id + "_" + simpleClassName + ".csv";
        File file = new File(fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        boolean fileAppendMode = filesForAppendMode.contains(fileName);
        FileWriter writer;
        try {
            writer = new FileWriter(file, fileAppendMode);
            CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';').withRecordSeparator('\n');
            csvPrinter = new CSVPrinter(writer, format);

            if(!fileAppendMode) {
                filesForAppendMode.add(fileName);
                print(csvType.header);
            }
        } catch (IOException e) {
            closeDueToError(e);
        }
    }

    public void buildValueRecord(String key, ValueAdapter value) {
        KeyValuesData valueData = value.getKeyValuesData();
        print(key, valueData.getValue(),
              valueData.getCount(), valueData.getFraction(),
              valueData.getIn_wiki(), valueData.getDescription());
    }

    public void buildKeyRecord(KeyAdapter key) {
        KeysAllData item = key.getKeysAllData();
        if(item != null) {
            print(item.getKey(), item.getCount_all(), item.getCount_all_fraction(),
                    item.getCount_nodes(), item.getCount_nodes_fraction(),
                    item.getCount_ways(), item.getCount_ways_fraction(),
                    item.getCount_relations(), item.getCount_relations_fraction());
        }
    }

    public void buildRestCallRecord(RestData restData) {
        print(restData.asObjectArray());
    }

    private void print(Object... values) {
        if(csvPrinter != null) {
            try {
                csvPrinter.printRecord(values);
            } catch (IOException e) {
                closeDueToError(e);
            }
        }
    }

    private void closeDueToError(IOException e) {
        System.out.println("Closing csvPrinter due to error");
        e.printStackTrace();
        close();
    }


    @Override
    public void close() {
        if(csvPrinter != null) {
            try { csvPrinter.close(); } catch (Exception e) { /*ignore*/ }
            csvPrinter = null;
        }
    }
}
