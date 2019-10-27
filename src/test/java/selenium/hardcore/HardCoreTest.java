package selenium.hardcore;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;
import selenium.base.googleCloud.GoogleCloudService;
import selenium.base.googleCloud.ComparingResults;

import java.util.concurrent.TimeUnit;

public class HardCoreTest {
    private static WebDriver webDriver;
    private static String mainHandler;
    private static final String RESULT_OF_COINTING = "Total " +
            "Estimated Cost: USD 1,082.77 per 1 month";
    private final String LINK_FOR_CLOUD_GOOGLE = "https://cloud.google.com/";
    private final int TIME_WAITING_PAGE = 30;
    private final String TEXT_FOR_SEARCH_LINE = "Google Cloud Platform Pricing Calculator";
    private String resultOfConting;

    @BeforeMethod
    public void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(TIME_WAITING_PAGE, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TIME_WAITING_PAGE, TimeUnit.SECONDS);
        webDriver.get(LINK_FOR_CLOUD_GOOGLE);
        mainHandler = webDriver.getWindowHandle();
        GoogleCloudService googleCloudService = new GoogleCloudService(webDriver);
        googleCloudService.searchForCalculator(TEXT_FOR_SEARCH_LINE).goToTheCalculatorLink();
        resultOfConting = googleCloudService.enterFormValues();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

    @Test (description = "Hurt me plenty test")
    public void compareResultOfCointing() {
        ComparingResults compare = new ComparingResults(webDriver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("VM class: regular", compare.getVmRegular());
        softAssert.assertEquals("Instance type: n1-standard-8", compare.getTextInstanceType());
        softAssert.assertEquals("Region: Frankfurt", compare.getRegion());
        softAssert.assertEquals("Total available local SSD space 2x375 GB", compare.getLocalSSd());
        softAssert.assertEquals("Commitment term: 1 Year", compare.getTextCommitmentTerm());
        softAssert.assertEquals(RESULT_OF_COINTING, compare.getResultOfCointing());
        softAssert.assertAll("No matches found");
    }

    @Test (description = "Hardcore test")
    public void compareEmailResultOfCointing() {
        GoogleCloudService googleCloudService = new GoogleCloudService(webDriver);
        googleCloudService.sendEmail(googleCloudService.createNewEmail(mainHandler));
        Assert.assertTrue(resultOfConting.contains(googleCloudService.getRentCost()), "Results of coining differ");
    }
}