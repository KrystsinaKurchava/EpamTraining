package selenium.hurtMePlenty.pageObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.base.GoogleCloudSearchCalculator;
import selenium.bringItOut.pageObject.PastebinHome;
import selenium.bringItOut.pageObject.PastebinNewPaste;

public class Tests {
    private static WebDriver webDriver;

    @Before
    public void before() {
        webDriver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        //webDriver.quit();
    }

    @Test
    public void taskTask() {
        webDriver.get("https://cloud.google.com/");
        GoogleCloudSearchCalculator googleCloudSearchCalculator = new GoogleCloudSearchCalculator(webDriver);
        googleCloudSearchCalculator.searchForCalculator();
    }
}
