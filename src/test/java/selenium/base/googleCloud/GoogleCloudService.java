package selenium.base.googleCloud;

import org.openqa.selenium.WebDriver;

public class GoogleCloudService {
    private String mailHandler;
    private final Integer NUMBER_OF_INSTANCE = 4;
    protected WebDriver webDriver;

    public GoogleCloudService(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String enterFormValues() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(webDriver);
        googleCloudCalculatorPage.switchToFrame();
        googleCloudCalculatorPage.selectPartComputeEngineClick();
        googleCloudCalculatorPage.inputNumberOfInstanceValue(NUMBER_OF_INSTANCE);
        googleCloudCalculatorPage.selectOperationSystemClick();
        googleCloudCalculatorPage.selectOptionOperationSystemElementClick();
        googleCloudCalculatorPage.selectVMClassClick();
        googleCloudCalculatorPage.selectOptionVMRegularClick();
        googleCloudCalculatorPage.scrollToVMClassElement();
        googleCloudCalculatorPage.selectMachineTypeClick();
        googleCloudCalculatorPage.selectOptionMachineTypeClick();
        googleCloudCalculatorPage.checkboxAddGrup();
        googleCloudCalculatorPage.selectNumberOfGrupClick();
        googleCloudCalculatorPage.selectOptionNumberOfGrupValueClick();
        googleCloudCalculatorPage.selectGPUtypeClick();
        googleCloudCalculatorPage.selectOptionGPUtypeNvidiaClick();
        googleCloudCalculatorPage.selectLocalSSdClick();
        googleCloudCalculatorPage.selectOptionLocalSSdValueClick();
        googleCloudCalculatorPage.selectDataCenreLocationClick();
        googleCloudCalculatorPage.selectOptionDataCenterLocationValueClick();
        googleCloudCalculatorPage.selectCommitedUsageClick();
        googleCloudCalculatorPage.selectOptionCommitedUsage1yearClick();
        googleCloudCalculatorPage.buttonAddToEstimateClick();
        return googleCloudCalculatorPage.getResultOfCointing();
    }

    public String getRentCost() {
        TrickEmailsPage trickEmailsPage = new TrickEmailsPage(webDriver);
        webDriver.switchTo().window(mailHandler);
        trickEmailsPage.scrollToInputEmailAddress();
        trickEmailsPage.waitForAppearanceExpanderToMail();
        return trickEmailsPage.getMoneyValue();
    }

    public void sendEmail(String mail) {
        GoogleCloudCalculatorEmailPage googleCloudCalculatorEmailPage = new GoogleCloudCalculatorEmailPage(webDriver);
        googleCloudCalculatorEmailPage.buttonToSentEmailClick();
        googleCloudCalculatorEmailPage.enterEmailAddress(mail);
        googleCloudCalculatorEmailPage.scrollToEmailAddress();
        googleCloudCalculatorEmailPage.sendEmail();
    }

    public GoogleCloudSearchResult searchForCalculator(String text) {
        GoogleCloudSearchCalculator googleCloudSearch = new GoogleCloudSearchCalculator(webDriver);
        googleCloudSearch.enterSearchLine(text);
        googleCloudSearch.startSearch();
        return new GoogleCloudSearchResult(webDriver);
    }

    public String createNewEmail(String handler) {
        TrickEmailsPage tenMailPage = new TrickEmailsPage(webDriver);
        mailHandler = tenMailPage.openMailPage(webDriver.getWindowHandle());
        webDriver.switchTo().window(mailHandler);
        String email = tenMailPage.createNewEmail();
        webDriver.switchTo().window(handler);
        return email;
    }
}