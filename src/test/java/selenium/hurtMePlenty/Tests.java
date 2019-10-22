package selenium.hurtMePlenty;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.base.GoogleCloudCalculatorBase;
import selenium.base.GoogleCloudSearchCalculator;

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
    public void taskTask() throws InterruptedException {

        webDriver.get("https://cloud.google.com/");
        GoogleCloudSearchCalculator googleCloudSearchCalculator = new GoogleCloudSearchCalculator(webDriver);
        googleCloudSearchCalculator.searchForCalculator();
        GoogleCloudCalculatorBase input = new GoogleCloudCalculatorBase(webDriver);

        input.enterFormValues();
    }
}
