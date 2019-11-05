package selenium.base.googleCloud;

public class GoogleCloudService {
    private String mailHandler;
    private final Integer NUMBER_OF_INSTANCE = 4;
    private final String CLOUD_GOOGLE_LINK = "https://cloud.google.com/";

    public String enterFormValues() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage();
        googleCloudCalculatorPage.switchToFrame();
        googleCloudCalculatorPage.partComputeEngineSelectClick();
        googleCloudCalculatorPage.numberOfInstanceValueInput(NUMBER_OF_INSTANCE);
        googleCloudCalculatorPage.operationSystemSelectClick();
        googleCloudCalculatorPage.optionOperationSystemElementSelectClick();
        googleCloudCalculatorPage.vmClassSelectClick();
        googleCloudCalculatorPage.optionVMRegularSelectClick();
        googleCloudCalculatorPage.scrollToVMClassElement();
        googleCloudCalculatorPage.machineTypeSelectClick();
        googleCloudCalculatorPage.optionMachineTypeSelectClick();
        googleCloudCalculatorPage.addGrupCheckboxClick();
        googleCloudCalculatorPage.numberOfGrupSelectClick();
        googleCloudCalculatorPage.optionNumberOfGrupValueSelectClick();
        googleCloudCalculatorPage.gpuTypeSelectClick();
        googleCloudCalculatorPage.optionGPUtypeNvidiaSelectClick();
        googleCloudCalculatorPage.localSSdSelectClick();
        googleCloudCalculatorPage.optionLocalSSdValueSelectClick();
        googleCloudCalculatorPage.dataCenreLocationSelectClick();
        googleCloudCalculatorPage.optionDataCenterLocationValueSelectClick();
        googleCloudCalculatorPage.commitedUsageSelectClick();
        googleCloudCalculatorPage.optionCommitedUsage1yearSelectClick();
        googleCloudCalculatorPage.addToEstimateButtonClick();
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
        googleCloudCalculatorEmailPage.sendEmailButtonClick();
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