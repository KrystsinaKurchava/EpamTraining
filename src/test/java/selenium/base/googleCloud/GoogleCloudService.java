package selenium.base.googleCloud;

public class GoogleCloudService {
    private String mailHandler;
    private final Integer NUMBER_OF_INSTANCE = 4;
    private final String LINK_FOR_CLOUD_GOOGLE = "https://cloud.google.com/";

    public String enterFormValues() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage();
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
        TrickEmailsPage trickEmailsPage = new TrickEmailsPage();
        trickEmailsPage.switchToWindow(mailHandler);
        trickEmailsPage.scrollToInputEmailAddress();
        trickEmailsPage.waitForAppearanceExpanderToMail();
        return trickEmailsPage.getMoneyValue();
    }

    public void sendEmail(String mail) {
        GoogleCloudCalculatorEmailPage googleCloudCalculatorEmailPage = new GoogleCloudCalculatorEmailPage();
        googleCloudCalculatorEmailPage.buttonToSentEmailClick();
        googleCloudCalculatorEmailPage.enterEmailAddress(mail);
        googleCloudCalculatorEmailPage.scrollToEmailAddress();
        googleCloudCalculatorEmailPage.sendEmail();
    }

    public void searchForCalculator(String text) {
        GoogleCloudSearchCalculator googleCloudSearch = new GoogleCloudSearchCalculator();
        googleCloudSearch.goToPage(LINK_FOR_CLOUD_GOOGLE);
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