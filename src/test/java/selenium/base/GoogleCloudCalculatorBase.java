package selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class GoogleCloudCalculatorBase extends PageObjectBase {
    @FindBy(css = "#maia-main iframe")
    private WebElement frame;
    @FindBy(css = "md-tab-item.md-tab:nth-child(1)")
    private WebElement selectPartComputeEngine;
    @FindBy(css = "#input_53")
    private WebElement inputNumberOfInstance;
    @FindBy(css = "#select_65")
    private WebElement selectOperationSystem;
    private final By selectOptionOperationSystemElement = new By.ByCssSelector("#select_option_55");
    @FindBy(css = "#select_69")
    private WebElement selectVMClass;
    private final By selectOptionVMRegular = new By.ByCssSelector("#select_option_67");
    @FindBy(css = "#select_76")
    private WebElement selectMachineType;
    private final By selectOptionMachineType = new By.ByCssSelector("#select_option_217");
    @FindBy(css = "md-checkbox[aria-label='Add GPUs']")
    private WebElement checkboxAddGrup;
    @FindBy(css = "#select_348")
    private WebElement selectNumberOfGrup;
    private final By selectOptionNumberOfGrupValue = new By.ByCssSelector("#select_option_353");
    @FindBy(css = "#select_350")
    private WebElement selectGPUtype;
    private final By selectOptionGPUtypeNvidia = new By.ByCssSelector("#select_option_360");
    @FindBy(css = "#select_78")
    private WebElement selectLocalSSd;
    private final By selectOptionLocalSSdValue = new By.ByCssSelector("#select_option_171");
    @FindBy(css = "#select_80")
    private WebElement selectDataCenreLocation;
    private final By selectOptionDataCenreLocationValue = new By.ByCssSelector("#select_option_185");
    @FindBy(css = "#select_value_label_52")
    private WebElement selectCommitedUsage;
    private final By selectOptionCommitedUsage1year = new By.ByCssSelector("#select_option_83");
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//div//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;
    @FindBy(css = "h2.md-title:nth-child(2) > b:nth-child(1)")
    private WebElement resultOfCointing;
    private final String NUMBER_OF_INSTANCE = "4";

    public GoogleCloudCalculatorBase(WebDriver webDriver) {
        super(webDriver);
    }

    public String getResultOfCointing() {
        return resultOfCointing.getText();
    }

    public void enterFormValues() {
        webDriver.switchTo().frame(frame);
        selectPartComputeEngine.click();
        inputNumberOfInstance.sendKeys(NUMBER_OF_INSTANCE);
        selectOperationSystem.click();
        findElement(selectOptionOperationSystemElement).click();
        selectVMClass.click();
        findElement(selectOptionVMRegular).click();
        scrollToElement(selectVMClass);
        selectMachineType.click();
        findElement(selectOptionMachineType).click();
        checkboxAddGrup.click();
        selectNumberOfGrup.click();
        findElement(selectOptionNumberOfGrupValue).click();
        selectGPUtype.click();
        findElement(selectOptionGPUtypeNvidia).click();
        selectLocalSSd.click();
        findElement(selectOptionLocalSSdValue).click();
        selectDataCenreLocation.click();
        findElement(selectOptionDataCenreLocationValue).click();
        selectCommitedUsage.click();
        findElement(selectOptionCommitedUsage1year).click();
        buttonAddToEstimate.click();
    }
}