package de.gaiasoft.osm.taglib.gen.util;

import java.io.*;
import java.util.Properties;

/**
 * Helper class for doing file IO operations.
 */
public class FileIoHelper {
    private static FileIoHelper instance = null;
    private FileIoHelper() {}

    public static FileIoHelper getInstance() {
        if(instance == null) {
            instance = new FileIoHelper();
        }
        return instance;
    }

    public String readFileIntoString(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        StringBuilder result = new StringBuilder();
        do {
            line = br.readLine();
            if(line != null) {
                result.append(line).append('\n');
            }
        } while(line != null);
        fr.close();
        return result.toString();
    }

    public void writeStringIntoFile(String fileName, String writeData) throws IOException {
        FileWriter fw = new FileWriter(new File(fileName));
        fw.write(writeData);
        fw.close();
    }

    public Properties readProperties(String propertiesFile) throws IOException {
        Properties properties = new Properties();
        try(final FileInputStream fis = new FileInputStream(propertiesFile)) {
            properties.load(fis);
        }
        return properties;
    }
}
