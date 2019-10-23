package selenium.hardcore;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.base.GoogleCloudSearchCalculator;
import selenium.hardcore.pageObject.GoogleCloudCalculatorWithEmail;
import selenium.hardcore.pageObject.TrickEmailAddress;

import java.util.concurrent.TimeUnit;

public class HardCoreTest {
    private static WebDriver webDriver;
    private static String mainHandler;

    @Before
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        //webDriver.quit();
    }

    @Test
    public void taskTask() throws InterruptedException {
        webDriver.get("https://cloud.google.com/");
        mainHandler = webDriver.getWindowHandle();
        GoogleCloudSearchCalculator googleCloudSearchCalculator = new GoogleCloudSearchCalculator(webDriver);
        googleCloudSearchCalculator.searchForCalculator();
        GoogleCloudCalculatorWithEmail estimateEmailPage = new GoogleCloudCalculatorWithEmail(webDriver);
        estimateEmailPage.enterFormValues();
        TrickEmailAddress tenMailPage = new TrickEmailAddress(webDriver, mainHandler);
        tenMailPage.switchToMailWindow();
        String email = tenMailPage.createNewEmail();
        webDriver.switchTo().window(mainHandler);
        estimateEmailPage.sendEmail(email);
        Assert.assertEquals(true, estimateEmailPage.getResultOfCointing().contains(tenMailPage.getRentCost()));
    }
}

