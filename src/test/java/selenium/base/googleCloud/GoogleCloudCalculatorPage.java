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
    private WebElement numberOfGrupSelect;
    @FindBy(id = "select_option_353")
    private WebElement optionNumberOfGrupValueSelect;
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

    public void switchToFrame() {
        webDriver.switchTo().frame(frame);
    }

    public void partComputeEngineSelectClick() {
        partComputeEngineSelect.click();
    }

    public void numberOfInstanceValueInput(Integer numberOfInstance) {
        numberOfInstanceInput.sendKeys(numberOfInstance.toString());
    }

    public void operationSystemSelectClick() {
        operationSystemSelect.click();
    }

    public void optionOperationSystemElementSelectClick() {
        optionOperationSystemElementSelect.click();
    }

    public void vmClassSelectClick() {
        vmClassSelect.click();
    }

    public void optionVMRegularSelectClick() {
        optionVMRegularSelect.click();
    }

    public void scrollToVMClassElement() {
        scrollToElement(vmClassSelect);
    }

    public void machineTypeSelectClick() {
        machineTypeSelect.click();
    }

    public void optionMachineTypeSelectClick() {
        optionMachineTypeSelect.click();
    }

    public void addGrupCheckboxClick() {
        addGrupCheckbox.click();
    }

    public void numberOfGrupSelectClick() {
        numberOfGrupSelect.click();
    }

    public void optionNumberOfGrupValueSelectClick() {
        optionNumberOfGrupValueSelect.click();
    }

    public void gpuTypeSelectClick() {
        gpuTypeSelect.click();
    }

    public void optionGPUtypeNvidiaSelectClick() {
        optionGPUtypeNvidiaSelect.click();
    }

    public void localSSdSelectClick() {
        localSSdSelect.click();
    }

    public void optionLocalSSdValueSelectClick() {
        optionLocalSSdValueSelect.click();
    }

    public void dataCenreLocationSelectClick() {
        dataCenreLocationSelect.click();
    }

    public void optionDataCenterLocationValueSelectClick() {
        optionDataCenterLocationValueSelect.click();
    }

    public void commitedUsageSelectClick() {
        commitedUsageSelect.click();
    }

    public void optionCommitedUsage1yearSelectClick() {
        optionCommitedUsage1yearSelect.click();
    }

    public void addToEstimateButtonClick() {
        addToEstimateButton.click();
    }
}