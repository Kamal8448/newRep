package com.kamal.datareader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyDataReader {
    public static String read_Data(String filename, String key) throws FileNotFoundException {
        String fileLocation ="testdata";
        FileInputStream fis = new FileInputStream(fileLocation + "\\" + filename);
        Properties p = new Properties();
        try {
            p.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value = p.getProperty(key);
        return value;
    }
}
