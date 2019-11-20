package selenium.base.googleCloud;

import selenium.base.WebDriverSingleton;

public class GoogleCloudService {
    private String mailHandler;
    private final Integer NUMBER_OF_INSTANCE = 4;
    private final String CLOUD_GOOGLE_LINK = "https://cloud.google.com/";

    public String enterFormValues() {
        return new GoogleCloudCalculatorPage()
                .switchToFrame()
                .clickPartComputeEngineSelect()
                .inputNumberOfInstanceValue(NUMBER_OF_INSTANCE)
                .clickOperationSystemSelect()
                .clickOptionOperationSystemElementSelect()
                .clickVMClassSelect()
                .clickOptionVMRegularSelect()
                .scrollToVMClassElement()
                .clickMachineTypeSelect()
                .clickOptionMachineTypeSelect()
                .clickAddGrupCheckbox()
                .clickNumberOfGrupSelect()
                .clickOptionNumberOfGrupValueSelect()
                .clickGPUTypeSelect()
                .clickOptionGPUtypeNvidiaSelect()
                .clickLocalSSdSelect()
                .clickOptionLocalSSdValueSelect()
                .clickDataCenreLocationSelect()
                .clickOptionDataCenterLocationValueSelect()
                .clickCommitedUsageSelect()
                .clickOptionCommitedUsage1yearSelect()
                .clickAddToEstimateButton()
                .getResultOfCointing();
    }

    public String getRentCost() {
        TrickEmailsPage trickEmailsPage = new TrickEmailsPage();
        trickEmailsPage.switchToWindow(mailHandler);
        trickEmailsPage.scrollToInputEmailAddress();
        trickEmailsPage.waitForAppearanceExpanderToMail();
        return trickEmailsPage.getMoneyValue();
    }

    public void sendEmail(String mail) {
        new GoogleCloudCalculatorEmailPage()
                .clickSendEmailButton()
                .enterEmailAddress(mail)
                .scrollToEmailAddress()
                .sendEmail();
    }

    public void searchForCalculator(String text) {
        WebDriverSingleton
                .getWebDriver()
                .get(CLOUD_GOOGLE_LINK);
        new GoogleCloudSearchCalculator()
                .enterSearchLine(text)
                .startSearch();
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