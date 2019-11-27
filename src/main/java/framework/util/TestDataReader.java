package framework.util;

import framework.runner.Parameters;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(Parameters.instance().getPropertiesFile());
    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}