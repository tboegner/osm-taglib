package de.gaiasoft.osm.taglib.gen.generation;

import java.io.*;

/**
 * Helper class for doing file IO operations.
 */
public class FileIoHelper {
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

}
