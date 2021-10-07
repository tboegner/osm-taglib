package de.gaiasoft.osm.taglib.gen.generation;

import de.gaiasoft.osm.taglib.gen.processing.InterpretationResult;
import de.gaiasoft.osm.taglib.gen.processing.KeySegment;
import de.gaiasoft.osm.taglib.gen.util.FileIoHelper;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static de.gaiasoft.osm.taglib.gen.util.StringHelper.appendSpaces;
import static de.gaiasoft.osm.taglib.gen.util.StringHelper.toConstantDefinition;

public class JavaTagLibGenerator implements TagLibGeneratorStrategy {
    private final String resourcesDir;
    private final String outputDir;

    public JavaTagLibGenerator(String resourcesDir, String outputDir) {
        this.resourcesDir = resourcesDir;
        this.outputDir = outputDir;
    }

    public void generateSourceCode(InterpretationResult interpretationResult) {
        generateKeyDefinitions(interpretationResult);
        generateValueDefinitions(interpretationResult);
    }

    private void generateKeyDefinitions(InterpretationResult interpretationResult) {
        StringBuilder sb = new StringBuilder(1024);
        for (KeySegment segment : KeySegment.values()) {
            buildKeyEnumDefinition(interpretationResult.getKeySetOfSegment(segment), sb);
        }
        generateDefinitionFromTemplate("", "Key", sb.toString());
    }

    private void buildKeyEnumDefinition(Set<KeyDefinition> keySet, StringBuilder sb) {
        for(KeyDefinition keyDefinition : keySet) {
            generateKeyDefinition(sb, keyDefinition);
        }
    }

    private void generateValueDefinitions(InterpretationResult interpretationResult) {
        for (KeySegment segment : KeySegment.values()) {
            Map<String, Set<String>> keyValueMap = interpretationResult.getKeyValueMappingsOfSegement(segment);
            for (String key : keyValueMap.keySet()) {
                String valueDef = buildValueEnumDefinition(keyValueMap, key);
                generateDefinitionFromTemplate("_"+key.toUpperCase(), "Value", valueDef);
            }
        }
    }

    private String buildValueEnumDefinition(Map<String, Set<String>> keyValueMap, String key) {
        StringBuilder sb = new StringBuilder(1024);
        for(String value : keyValueMap.get(key)) {
            appendValueDefinition(sb, value);
        }
        return sb.toString();
    }

    private void generateDefinitionFromTemplate(String type, String targetFile, String dynamicContent) {
        try {
            String code = readCodeTemplate(targetFile);
            code = code.replaceAll("#0#", type);
            code = code.replaceFirst("#1#", dynamicContent);
            FileIoHelper.getInstance().writeStringIntoFile(outputDir +targetFile+type+".java", code);
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    private String readCodeTemplate(String targetFile) throws IOException {
        return FileIoHelper.getInstance().readFileIntoString(resourcesDir + targetFile + ".java_tmpl");
    }

    private void generateKeyDefinition(StringBuilder sb, KeyDefinition keyDefinition) {
        String key = keyDefinition.getId();
        appendSpaces(sb,4);
        sb.append(toConstantDefinition(key));
        sb.append("(\"").append(key).append("\"");
        sb.append("),\n");
    }

    private void appendValueDefinition(StringBuilder sb, String value) {
        appendSpaces(sb,4);
        sb.append(toConstantDefinition(value));
        sb.append("(\"").append(value).append("\"),\n");
    }


}
