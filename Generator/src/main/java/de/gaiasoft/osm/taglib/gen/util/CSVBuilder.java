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

public class CSVBuilder implements AutoCloseable{
    private CSVPrinter csvPrinter;

    public CSVBuilder(String baseFilename, String simpleClassName) throws IOException {
        File file = new File(ConfigManager.getInstance().getLogDir()+baseFilename+"_"+simpleClassName+".csv");
        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileWriter writer = new FileWriter(file);
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';').withRecordSeparator('\n');
        csvPrinter = new CSVPrinter(writer, format);
    }

    public void buildKeyValueMapHeader() {
        print("key", "value", "count", "fraction", "in_wiki", "description");
    }

    public void buildKeySetHeader() {
        print("Key", "count_all", "count_all_fraction", "count_nodes", "count_nodes_fraction",
              "count_ways", "count_ways_fraction", "count_relations", "count_relations_fraction");
    }

    public void buildValueRecord(String key, ValueAdapter value) {
        KeyValuesData valueData = value.getKeyValuesData();
        print(key, valueData.getValue(),
              valueData.getCount(), valueData.getFraction(),
              valueData.getIn_wiki(), valueData.getDescription());
    }

    public void buildKeyRecord(KeyAdapter key) {
        KeysAllData item = key.getKeysAllData();
        print(item.getKey(), item.getCount_all(), item.getCount_all_fraction(),
                item.getCount_nodes(), item.getCount_nodes_fraction(),
                item.getCount_ways(), item.getCount_ways_fraction(),
                item.getCount_relations(), item.getCount_relations_fraction());
    }

    private void print(Object... values) {
        if(csvPrinter != null) {
            try {
                csvPrinter.printRecord(values);
            } catch (IOException e) {
                System.out.println("Closing csvPrinter due to error");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {
        if(csvPrinter != null) {
            try { csvPrinter.close(); } catch (Exception e) { /*ignore*/ }
            csvPrinter = null;
        }
    }
}
