package framework.util;

import framework.runner.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class TestDataReader {

    private static ResourceBundle resourceBundle = getEnvironmentLink();

    private static ResourceBundle getEnvironmentLink() {
        try {
            FileInputStream fileInputStream = new FileInputStream(String.format("./src/test/resources/%s.properties", (Parameters.instance().getPropertiesFile())));
            resourceBundle = new PropertyResourceBundle(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resourceBundle;
    }
        public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}