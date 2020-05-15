package de.gaiasoft.osm.taglib.gen.generation;

import de.gaiasoft.osm.taglib.gen.processing.InterpretationResult;
import de.gaiasoft.osm.taglib.gen.processing.KeySegment;
import de.gaiasoft.osm.taglib.gen.util.FileIoHelper;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static de.gaiasoft.osm.taglib.gen.util.StringHelper.appendSpaces;
import static de.gaiasoft.osm.taglib.gen.util.StringHelper.toConstantDefinition;

public class JavaScriptTagLibGenerator implements TagLibGeneratorStrategy {
    private String resourcesDir;
    private String outputDir;

    public JavaScriptTagLibGenerator(String resourcesDir, String outputDir) {
        this.resourcesDir = resourcesDir;
        this.outputDir = outputDir;
    }

    public void generateSourceCode(InterpretationResult interpretationResult) {
        StringBuilder sb = new StringBuilder(1024);
        sb.append("const osmTags = {\n");
        for (KeySegment segment : KeySegment.values()) {
            Map<String, Set<String>> keyValueMapOfSegement = interpretationResult.getKeyValueMappingsOfSegement(segment);
            if(keyValueMapOfSegement.size() > 0)
            buildKeyValueEnumDefinition(keyValueMapOfSegement, sb);
        }
        sb.append("};\n");
        generateJsFile( "osmtaglib", sb.toString());
    }

    private void buildKeyValueEnumDefinition(Map<String, Set<String>> keyValueMap, StringBuilder sb) {
        boolean first = true;
        for (String key : keyValueMap.keySet()) {
            if(first) {
                first = false;
            } else {
                sb.append(",\n");
            }
            generateKeyDefinition(sb, key);
            generateValueDefinitions(keyValueMap, key, sb);
        }
        sb.append("\n");
    }

    private void generateKeyDefinition(StringBuilder sb, String key) {
        appendSpaces(sb,4).append(toConstantDefinition(key)).append(": ");
    }

    private void generateValueDefinitions(Map<String, Set<String>> keyValueMap, String key, StringBuilder sb) {
        sb.append("{\n");
        boolean firstValue = true;
        for(String value : keyValueMap.get(key)) {
            if(firstValue) {
                firstValue = false;
            } else {
                sb.append(",\n");
            }
            appendValueDefinition(sb, key, value);
        }
        sb.append("\n");
        appendSpaces(sb,4).append("}");
    }

    private void appendValueDefinition(StringBuilder sb, String key, String value) {
        appendSpaces(sb,8).append(toConstantDefinition(value));
        sb.append(": '").append(key).append("=").append(value).append("'");
        //,
    }

    private void generateJsFile(String targetFile, String code) {
        try {
            FileIoHelper.getInstance().writeStringIntoFile(outputDir +targetFile+".js", code);
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

}
