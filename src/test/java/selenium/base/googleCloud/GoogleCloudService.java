package selenium.base.googleCloud;

public class GoogleCloudService {
    private String mailHandler;
    private final Integer NUMBER_OF_INSTANCE = 4;
    private final String CLOUD_GOOGLE_LINK = "https://cloud.google.com/";

    public String enterFormValues() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage();
        googleCloudCalculatorPage.switchToFrame();
        googleCloudCalculatorPage.clickPartComputeEngineSelect();
        googleCloudCalculatorPage.inputNumberOfInstanceValue(NUMBER_OF_INSTANCE);
        googleCloudCalculatorPage.clickOperationSystemSelect();
        googleCloudCalculatorPage.clickOptionOperationSystemElementSelect();
        googleCloudCalculatorPage.clickVMClassSelect();
        googleCloudCalculatorPage.clickOptionVMRegularSelect();
        googleCloudCalculatorPage.scrollToVMClassElement();
        googleCloudCalculatorPage.clickMachineTypeSelect();
        googleCloudCalculatorPage.clickOptionMachineTypeSelect();
        googleCloudCalculatorPage.clickAddGrupCheckbox();
        googleCloudCalculatorPage.clickNumberOfGrupSelect();
        googleCloudCalculatorPage.clickOptionNumberOfGrupValueSelect();
        googleCloudCalculatorPage.clickGPUTypeSelect();
        googleCloudCalculatorPage.clickOptionGPUtypeNvidiaSelect();
        googleCloudCalculatorPage.clickLocalSSdSelect();
        googleCloudCalculatorPage.clickOptionLocalSSdValueSelect();
        googleCloudCalculatorPage.clickDataCenreLocationSelect();
        googleCloudCalculatorPage.clickOptionDataCenterLocationValueSelect();
        googleCloudCalculatorPage.clickCommitedUsageSelect();
        googleCloudCalculatorPage.clickOptionCommitedUsage1yearSelect();
        googleCloudCalculatorPage.clickAddToEstimateButton();
        return googleCloudCalculatorPage.getResultOfCointing();
    }

    public String getRentCost() {
        TrickEmailsPage trickEmailsPage = new TrickEmailsPage();
        trickEmailsPage.switchToWindow(mailHandler);
        trickEmailsPage.scrollToInputEmailAddress();
        trickEmailsPage.waitForAppearanceExpanderToMail();
        return trickEmailsPage.getMoneyValue();
    }

    public void sendEmail(String mail) {
        GoogleCloudCalculatorEmailPage googleCloudCalculatorEmailPage = new GoogleCloudCalculatorEmailPage();
        googleCloudCalculatorEmailPage.clickSendEmailButton();
        googleCloudCalculatorEmailPage.enterEmailAddress(mail);
        googleCloudCalculatorEmailPage.scrollToEmailAddress();
        googleCloudCalculatorEmailPage.sendEmail();
    }

    public void searchForCalculator(String text) {
        GoogleCloudSearchCalculator googleCloudSearch = new GoogleCloudSearchCalculator();
        googleCloudSearch.goToPage(CLOUD_GOOGLE_LINK);
        googleCloudSearch.enterSearchLine(text);
        googleCloudSearch.startSearch();
    }

    public void goToTheCalculatorLink() {
        new GoogleCloudSearchResult().goToTheCalculatorLink();
    }

    public String createNewEmail() {
        TrickEmailsPage tenMailPage = new TrickEmailsPage();
        String mainHandler = tenMailPage.getCurrentWindowHandler();
        mailHandler = tenMailPage.openMailPage(tenMailPage.getCurrentWindowHandler());
        tenMailPage.switchToWindow(mailHandler);
        String email = tenMailPage.createNewEmail();
        tenMailPage.switchToWindow(mainHandler);
        return email;
    }
}