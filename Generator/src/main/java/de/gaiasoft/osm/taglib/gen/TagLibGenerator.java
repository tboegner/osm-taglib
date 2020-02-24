package de.gaiasoft.osm.taglib.gen;

import de.gaiasoft.osm.taglib.gen.aggregation.AggregationResult;
import de.gaiasoft.osm.taglib.gen.aggregation.FileKeySetNoValuesAggregator;
import de.gaiasoft.osm.taglib.gen.aggregation.KeySetTagAggregator;
import de.gaiasoft.osm.taglib.gen.aggregation.SqliteTagAggregator;
import de.gaiasoft.osm.taglib.gen.generation.JavaTagLibGenerator;
import de.gaiasoft.osm.taglib.gen.generation.TagLibGeneratorStrategy;
import de.gaiasoft.osm.taglib.gen.processing.InterpretationResult;
import de.gaiasoft.osm.taglib.gen.processing.KeySegment;
import de.gaiasoft.osm.taglib.gen.processing.TagInterpreter;

public class TagLibGenerator {

    public static void main (String[] args) {
        TagLibGenerator tagLibGenerator = new TagLibGenerator();
        tagLibGenerator.generateTagLib();
    }

    private static final String resourcesDir = "src/main/resources/";

    private TagInterpreter interpreter;
    private TagLibGeneratorStrategy generator;

    public TagLibGenerator() {
        interpreter = new TagInterpreter();
        generator = new JavaTagLibGenerator(resourcesDir);
    }

    private void generateTagLib() {
        InterpretationResult interpretationResult = new InterpretationResult();
        AggregationResult aggregatedKeys;
        AggregationResult aggregatedTags;

        // Primary keys + values
        aggregatedKeys = readKeySetFromFile("PrimaryKeys.csv");
        aggregatedTags = new SqliteTagAggregator(aggregatedKeys.getSimpleKeySet()).aggregateTagData();
        interpreter.interpretSegmentData(aggregatedTags, KeySegment.PRIMARY, interpretationResult);

        // Address keys, no values
        aggregatedKeys = readKeySetFromFile("AddressKeys.csv");
        interpreter.interpretSegmentData(aggregatedKeys, KeySegment.ADDRESS, interpretationResult);

        // Name keys, no values
        aggregatedKeys = readKeySetFromFile("NameKeys.csv");
        interpreter.interpretSegmentData(aggregatedKeys, KeySegment.NAME, interpretationResult);

        // Annotation keys, no values (maybe generate values for source in the future)
        aggregatedKeys = readKeySetFromFile("AnnotationKeys.csv");
        interpreter.interpretSegmentData(aggregatedKeys, KeySegment.ANNOTATION, interpretationResult);

        // Property keys + values
        aggregatedKeys = readKeySetFromFile("PropertyKeys.csv");
        aggregatedTags = new SqliteTagAggregator(aggregatedKeys.getSimpleKeySet()).aggregateTagData();
        interpreter.interpretSegmentData(aggregatedTags, KeySegment.PROPERTY, interpretationResult);

        // Whitelisted keys via REST-Aggregator
        aggregatedKeys = readKeySetFromFile("WhitelistedKeys.csv");
        aggregatedTags = new KeySetTagAggregator(aggregatedKeys.getSimpleKeySet()).aggregateTagData();
        interpreter.interpretSegmentData(aggregatedTags, KeySegment.DETAIL, interpretationResult);

        generator.generateSourceCode(interpretationResult);
    }

    private AggregationResult readKeySetFromFile(String fileName) {
        return new FileKeySetNoValuesAggregator(resourcesDir + fileName).aggregateTagData();
    }

}
