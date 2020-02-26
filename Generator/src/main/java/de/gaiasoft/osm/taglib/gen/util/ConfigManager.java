package de.gaiasoft.osm.taglib.gen.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static String propertiesFile = "Generator/src/main/resources/OsmTagLibGenerator.properties";
    private static ConfigManager instance;
    private Properties configProperties;
    private IOException configException;

    private ConfigManager() {
        try {
            configProperties = FileIoHelper.getInstance().readProperties(propertiesFile);
            configException = null;
        } catch (IOException e) {
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

    public boolean hasConfigError() {
        return configException != null;
    }

    public IOException getConfigException() {
        return configException;
    }

    public String getInputDir() {
        return configProperties.getProperty("inputDir")+"/";
    }

    public String getOutputDir() {
        return configProperties.getProperty("outputDir")+"/";
    }
}
