package yandexDick.pageObject;

import java.util.ResourceBundle;

public class TestDataReader {
    //System.getProperty("environment")
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("testResource");

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
