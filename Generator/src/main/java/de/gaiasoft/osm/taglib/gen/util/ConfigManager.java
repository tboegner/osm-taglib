package de.gaiasoft.osm.taglib.gen.util;

import de.gaiasoft.osm.taglib.gen.generation.JavaScriptTagLibGenerator;
import de.gaiasoft.osm.taglib.gen.generation.JavaTagLibGenerator;
import de.gaiasoft.osm.taglib.gen.generation.TagLibGeneratorStrategy;

import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static String propertiesFile = "Generator/src/main/resources/OsmTagLibGenerator.properties";
    private static ConfigManager instance;
    private Properties configProperties;
    private Exception configException;
    private GeneratorTargetLanguage targetLanguage;

    private enum GeneratorTargetLanguage {
        JAVA,
        JAVASCRIPT
    }

    private ConfigManager() {
        try {
            configProperties = FileIoHelper.getInstance().readProperties(propertiesFile);
            configException = null;

            targetLanguage = GeneratorTargetLanguage.valueOf(getGeneratorTargetLanguage().toUpperCase());
        } catch (Exception e) {
            configException = e;
        }
    }

    public static void setPropertiesFile(String propertiesFile) {
        ConfigManager.propertiesFile = propertiesFile;
    }

    public static ConfigManager getInstance() {
        if(instance == null || instance.hasConfigError()) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public TagLibGeneratorStrategy provideTagLibGenerator() {
        switch (targetLanguage) {
            case JAVASCRIPT: return new JavaScriptTagLibGenerator(getInputDir(), getOutputDir());
            case JAVA: return new JavaTagLibGenerator(getInputDir(), getOutputDir());
        }
        return null;
    }

    public boolean hasConfigError() {
        return configException != null;
    }

    public Exception getConfigException() {
        return configException;
    }

    public String getGeneratorTargetLanguage() {
        return configProperties.getProperty("generatorTargetLanguage");
    }

    public String getInputDir() {
        return configProperties.getProperty("inputDir")+"/";
    }

    public String getOutputDir() {
        return configProperties.getProperty("outputDir")+"/";
    }

    public String getLogDir() {
        return configProperties.getProperty("logDir")+"/";
    }

    public String getTaginfoBaseUrl() {
        return configProperties.getProperty("taginfoBaseUrl");
    }

    public boolean getFetchKeyStats() {
        return Boolean.parseBoolean(configProperties.getProperty("fetchKeyStats"));
    }
}
