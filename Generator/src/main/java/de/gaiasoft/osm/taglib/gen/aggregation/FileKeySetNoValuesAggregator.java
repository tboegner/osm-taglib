package de.gaiasoft.osm.taglib.gen.aggregation;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileKeySetNoValuesAggregator implements TagAggregatorStrategy {
    private String filename;

    public FileKeySetNoValuesAggregator(String filename) {
        this.filename = filename;
    }

    @Override
    public AggregationResult aggregateTagData() {
        AggregationResult result = new AggregationResult();
        File inputFile = new File(filename);
        try {
            CSVParser csvParser = CSVParser.parse(inputFile, Charset.defaultCharset(), CSVFormat.DEFAULT);
            csvParser.forEach(record -> {
                result.keySet.add(new KeyAdapter(record.get(0)));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
