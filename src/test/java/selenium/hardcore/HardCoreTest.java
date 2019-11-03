package selenium.hardcore;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import selenium.base.PageObjectBase;
import selenium.base.googleCloud.GoogleCloudService;
import selenium.base.googleCloud.ComparingResults;

public class HardCoreTest {
    private static final String RESULT_OF_COINTING = "Total " +
            "Estimated Cost: USD 1,082.77 per 1 month";
    private final String TEXT_FOR_SEARCH_LINE = "Google Cloud Platform Pricing Calculator";
    private String resultOfConting;
    private final String COMPARE_MISTAKE_TEXT = " value is unexpected";

    @BeforeMethod(description = "Preparation to the test")
    public void firstActions() {
        GoogleCloudService googleCloudService = new GoogleCloudService();
        googleCloudService.searchForCalculator(TEXT_FOR_SEARCH_LINE);
        googleCloudService.goToTheCalculatorLink();
        resultOfConting = googleCloudService.enterFormValues();
    }

    @AfterTest(description = "Closing browser after tests run")
    public void driverClose() {
        PageObjectBase.quit();
    }

    @Test(description = "Hurt me plenty test")
    public void compareResultOfCointing() {
        ComparingResults compare = new ComparingResults();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("VM class: regular", compare.getVmRegular(), "Virtual Machine" + COMPARE_MISTAKE_TEXT);
        softAssert.assertEquals("Instance type: n1-standard-8", compare.getTextInstanceType(), "Instance type" + COMPARE_MISTAKE_TEXT);
        softAssert.assertEquals("Region: Frankfurt", compare.getRegion(), "Region" + COMPARE_MISTAKE_TEXT);
        softAssert.assertEquals("Total available local SSD space 2x375 GB", compare.getLocalSSd(), "Hard drive" + COMPARE_MISTAKE_TEXT);
        softAssert.assertEquals("Commitment term: 1 Year", compare.getTextCommitmentTerm(), "Term" + COMPARE_MISTAKE_TEXT);
        softAssert.assertEquals(RESULT_OF_COINTING, compare.getResultOfCointing(), "Counting" + COMPARE_MISTAKE_TEXT);
        softAssert.assertAll("No matches found");
    }

    @Test(description = "Hardcore test")
    public void compareEmailResultOfCointing() {
        GoogleCloudService googleCloudService = new GoogleCloudService();
        googleCloudService.sendEmail(googleCloudService.createNewEmail());
        Assert.assertTrue(resultOfConting.contains(googleCloudService.getRentCost()), "Results of coining differ");
    }
}