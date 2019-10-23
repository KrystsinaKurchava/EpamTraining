package selenium.hardcore;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.base.GoogleCloudSearchCalculator;
import selenium.hurtMePlenty.ComparingResults;

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
        ComparingResults input = new ComparingResults(webDriver);
        input.enterFormValues();
        entFOrmTOTHeMAil create = new entFOrmTOTHeMAil(webDriver, mainHandler);
        create.sentToTheMAil();
        create.swithToMailWindow();
        String email = create.createNewEmail();
        webDriver.switchTo().window(mainHandler);
        create.inputEmail(email);

        Assert.assertEquals(true, create.getResultOfCointing());


    }
}

