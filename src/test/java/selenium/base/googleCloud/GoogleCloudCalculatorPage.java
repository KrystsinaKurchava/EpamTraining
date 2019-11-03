package selenium.base.googleCloud;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.PageObjectBase;

public class GoogleCloudCalculatorPage extends PageObjectBase {
    @FindBy(css = "#maia-main iframe")
    private WebElement frame;
    @FindBy(css = "md-tab-item.md-tab:nth-child(1)")
    private WebElement selectPartComputeEngine;
    @FindBy(id = "input_53")
    private WebElement inputNumberOfInstance;
    @FindBy(id = "select_65")
    private WebElement selectOperationSystem;
    @FindBy(id = "select_option_55")
    private WebElement selectOptionOperationSystemElement;
    @FindBy(id = "select_69")
    private WebElement selectVMClass;
    @FindBy(id = "select_option_67")
    private WebElement selectOptionVMRegular;
    @FindBy(id = "select_76")
    private WebElement selectMachineType;
    @FindBy(id = "select_option_217")
    private WebElement selectOptionMachineType;
    @FindBy(css = "md-checkbox[aria-label='Add GPUs']")
    private WebElement checkboxAddGrup;
    @FindBy(id = "select_348")
    private WebElement selectNumberOfGrup;
    @FindBy(id = "select_option_353")
    private WebElement selectOptionNumberOfGrupValue;
    @FindBy(id = "select_350")
    private WebElement selectGPUtype;
    @FindBy(id = "select_option_360")
    private WebElement selectOptionGPUtypeNvidia;
    @FindBy(id = "select_78")
    private WebElement selectLocalSSd;
    @FindBy(id = "select_option_171")
    private WebElement selectOptionLocalSSdValue;
    @FindBy(id = "select_80")
    private WebElement selectDataCenreLocation;
    @FindBy(id = "select_option_185")
    private WebElement selectOptionDataCenterLocationValue;
    @FindBy(id = "select_value_label_52")
    private WebElement selectCommitedUsage;
    @FindBy(id = "select_option_83")
    private WebElement selectOptionCommitedUsage1year;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//div//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;
    @FindBy(css = "h2.md-title:nth-child(2) > b:nth-child(1)")
    private WebElement resultOfCointing;

    public String getResultOfCointing() {
        return resultOfCointing.getText();
    }

    public void switchToFrame() {
        webDriver.switchTo().frame(frame);
    }

    public void selectPartComputeEngineClick() {
        selectPartComputeEngine.click();
    }

    public void inputNumberOfInstanceValue(Integer numberOfInstance) {
        inputNumberOfInstance.sendKeys(numberOfInstance.toString());
    }

    public void selectOperationSystemClick() {
        selectOperationSystem.click();
    }

    public void selectOptionOperationSystemElementClick() {
        selectOptionOperationSystemElement.click();
    }

    public void selectVMClassClick() {
        selectVMClass.click();
    }

    public void selectOptionVMRegularClick() {
        selectOptionVMRegular.click();
    }

    public void scrollToVMClassElement() {
        scrollToElement(selectVMClass);
    }

    public void selectMachineTypeClick() {
        selectMachineType.click();
    }

    public void selectOptionMachineTypeClick() {
        selectOptionMachineType.click();
    }

    public void checkboxAddGrup() {
        checkboxAddGrup.click();
    }

    public void selectNumberOfGrupClick() {
        selectNumberOfGrup.click();
    }

    public void selectOptionNumberOfGrupValueClick() {
        selectOptionNumberOfGrupValue.click();
    }

    public void selectGPUtypeClick() {
        selectGPUtype.click();
    }

    public void selectOptionGPUtypeNvidiaClick() {
        selectOptionGPUtypeNvidia.click();
    }

    public void selectLocalSSdClick() {
        selectLocalSSd.click();
    }

    public void selectOptionLocalSSdValueClick() {
        selectOptionLocalSSdValue.click();
    }

    public void selectDataCenreLocationClick() {
        selectDataCenreLocation.click();
    }

    public void selectOptionDataCenterLocationValueClick() {
        selectOptionDataCenterLocationValue.click();
    }

    public void selectCommitedUsageClick() {
        selectCommitedUsage.click();
    }

    public void selectOptionCommitedUsage1yearClick() {
        selectOptionCommitedUsage1year.click();
    }

    public void buttonAddToEstimateClick() {
        buttonAddToEstimate.click();
    }
}