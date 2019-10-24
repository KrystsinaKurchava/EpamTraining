package selenium.hurtMePlenty;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.base.GoogleCloudSearchCalculator;
import selenium.hurtMePlenty.pageObject.ComparingResults;

public class HurtMePlentyTests {
    private static final String RESULT_OF_COINTING = "Total " +
            "Estimated Cost: USD 1,082.77 per 1 month";
    private static WebDriver webDriver;
    private final String LINK_FOR_CLOUD_GOOGLE = "https://cloud.google.com/";

    @Before
    public void before() {
        webDriver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void taskTask() {
        webDriver.get(LINK_FOR_CLOUD_GOOGLE);
        GoogleCloudSearchCalculator googleCloudSearchCalculator = new GoogleCloudSearchCalculator(webDriver);
        googleCloudSearchCalculator.searchForCalculator();
        ComparingResults input = new ComparingResults(webDriver);
        ComparingResults compare = new ComparingResults(webDriver);
        input.enterFormValues();
        Assert.assertEquals("VM class: regular", compare.getVmRegular());
        Assert.assertEquals("Instance type: n1-standard-8", compare.getTextInstanceType());
        Assert.assertEquals("Region: Frankfurt", compare.getRegion());
        Assert.assertEquals("Total available local SSD space 2x375 GB", compare.getLocalSSd());
        Assert.assertEquals("Commitment term: 1 Year", compare.getTextCommitmentTerm());
        Assert.assertEquals(RESULT_OF_COINTING, compare.getResultOfCointing());
    }
}