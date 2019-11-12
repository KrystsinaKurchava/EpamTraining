package selenium.base.googleCloud;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.PageObjectBase;

public class GoogleCloudCalculatorPage extends PageObjectBase {
    @FindBy(css = "#maia-main iframe")
    private WebElement frame;
    @FindBy(css = "md-tab-item.md-tab:nth-child(1)")
    private WebElement partComputeEngineSelect;
    @FindBy(id = "input_53")
    private WebElement numberOfInstanceInput;
    @FindBy(id = "select_65")
    private WebElement operationSystemSelect;
    @FindBy(id = "select_option_55")
    private WebElement optionOperationSystemElementSelect;
    @FindBy(id = "select_69")
    private WebElement vmClassSelect;
    @FindBy(id = "select_option_67")
    private WebElement optionVMRegularSelect;
    @FindBy(id = "select_76")
    private WebElement machineTypeSelect;
    @FindBy(id = "select_option_217")
    private WebElement optionMachineTypeSelect;
    @FindBy(css = "md-checkbox[aria-label='Add GPUs']")
    private WebElement addGrupCheckbox;
    @FindBy(id = "select_348")
    private WebElement numberOfGPUsSelect;
    @FindBy(id = "select_option_353")
    private WebElement optionNumberOfGPUsValueSelect;
    @FindBy(id = "select_350")
    private WebElement gpuTypeSelect;
    @FindBy(id = "select_option_360")
    private WebElement optionGPUtypeNvidiaSelect;
    @FindBy(id = "select_78")
    private WebElement localSSdSelect;
    @FindBy(id = "select_option_171")
    private WebElement optionLocalSSdValueSelect;
    @FindBy(id = "select_80")
    private WebElement dataCenreLocationSelect;
    @FindBy(id = "select_option_185")
    private WebElement optionDataCenterLocationValueSelect;
    @FindBy(id = "select_value_label_52")
    private WebElement commitedUsageSelect;
    @FindBy(id = "select_option_83")
    private WebElement optionCommitedUsage1yearSelect;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//div//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;
    @FindBy(css = "h2.md-title:nth-child(2) > b:nth-child(1)")
    private WebElement resultOfCointing;

    public String getResultOfCointing() {
        return resultOfCointing.getText();
    }

    public GoogleCloudCalculatorPage switchToFrame() {
        webDriver.switchTo().frame(frame);
        return this;
    }

    public GoogleCloudCalculatorPage clickPartComputeEngineSelect() {
        partComputeEngineSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage inputNumberOfInstanceValue(Integer numberOfInstance) {
        numberOfInstanceInput.sendKeys(numberOfInstance.toString());
        return this;
    }

    public GoogleCloudCalculatorPage clickOperationSystemSelect() {
        operationSystemSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickOptionOperationSystemElementSelect() {
        optionOperationSystemElementSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickVMClassSelect() {
        vmClassSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickOptionVMRegularSelect() {
        optionVMRegularSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage scrollToVMClassElement() {
        scrollToElement(vmClassSelect);
        return this;
    }

    public GoogleCloudCalculatorPage clickMachineTypeSelect() {
        machineTypeSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickOptionMachineTypeSelect() {
        optionMachineTypeSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickAddGrupCheckbox() {
        addGrupCheckbox.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickNumberOfGrupSelect() {
        numberOfGPUsSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickOptionNumberOfGrupValueSelect() {
        optionNumberOfGPUsValueSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickGPUTypeSelect() {
        gpuTypeSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickOptionGPUtypeNvidiaSelect() {
        optionGPUtypeNvidiaSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickLocalSSdSelect() {
        localSSdSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickOptionLocalSSdValueSelect() {
        optionLocalSSdValueSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickDataCenreLocationSelect() {
        dataCenreLocationSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickOptionDataCenterLocationValueSelect() {
        optionDataCenterLocationValueSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickCommitedUsageSelect() {
        commitedUsageSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickOptionCommitedUsage1yearSelect() {
        optionCommitedUsage1yearSelect.click();
        return this;
    }

    public GoogleCloudCalculatorPage clickAddToEstimateButton() {
        addToEstimateButton.click();
        return this;
    }
}