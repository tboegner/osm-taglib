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
import de.gaiasoft.osm.taglib.gen.util.ConfigManager;

/**
 * Executable for generation of OsmTagLib.
 * Optional argument: Path to properties-file.
 */
public class TagLibGenerator {

    public static void main (String[] args) {
        try {
            if(args.length > 0) {
                ConfigManager.setPropertiesFile(args[0]);
            }
            ConfigManager config = ConfigManager.getInstance();
            if(config.hasConfigError()) {
                throw(config.getConfigException());
            }

            TagLibGenerator tagLibGenerator = new TagLibGenerator(config);
            tagLibGenerator.generateTagLib();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }

    }

    private TagInterpreter interpreter;
    private TagLibGeneratorStrategy generator;

    public TagLibGenerator(ConfigManager config) {
        interpreter = new TagInterpreter();
        generator = new JavaTagLibGenerator(config.getInputDir(), config.getOutputDir());
    }

    private void generateTagLib() {
        InterpretationResult interpretationResult = new InterpretationResult();
        AggregationResult aggregatedKeys;
        AggregationResult aggregatedTags;

        // Primary keys + values via REST (demand wiki entry)
        aggregatedTags = new KeySetTagAggregator(readKeySetFromFile("PrimaryKeys.csv").getSimpleKeySet())
                .withValueMustBeInWiki(true)
                .withPageSizeForKeyValue(100)
                .aggregateTagData();
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

        // Property keys + values via REST (demand wiki entry)
        aggregatedTags = new KeySetTagAggregator(readKeySetFromFile("PropertyKeys.csv").getSimpleKeySet())
                .withValueMustBeInWiki(true)
                .aggregateTagData();
        interpreter.interpretSegmentData(aggregatedTags, KeySegment.PROPERTY, interpretationResult);

        // Whitelisted keys via REST-Aggregator
        aggregatedTags = new KeySetTagAggregator(readKeySetFromFile("WhitelistedKeys.csv").getSimpleKeySet())
                .aggregateTagData();
        interpreter.interpretSegmentData(aggregatedTags, KeySegment.DETAIL, interpretationResult);

        generator.generateSourceCode(interpretationResult);
    }

    private AggregationResult readKeySetFromFile(String fileName) {
        return new FileKeySetNoValuesAggregator(ConfigManager.getInstance().getInputDir() + fileName).aggregateTagData();
    }

}
