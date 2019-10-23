package selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class GoogleCloudCalculatorBase extends PageObjectBase {
    @FindBy(css = "#maia-main iframe")
    private WebElement frame;
    @FindBy(css = "md-tab-item.md-tab:nth-child(1)")
    private WebElement partComputeEngine;
    @FindBy(css = "#input_53")
    private WebElement numberOfInstance;
    @FindBy(css = "#select_65")
    private WebElement operationSystem;
    private final By operationSystemElement = new By.ByCssSelector("#select_option_55");
    @FindBy(css = "#select_69")
    private WebElement vmClass;
    private final By vmRegular = new By.ByCssSelector("#select_option_67");
    @FindBy(css = "#select_76")
    private WebElement machineType;
    private final By machineTypeN1 = new By.ByCssSelector("#select_option_217");
    @FindBy(css = "md-checkbox[aria-label='Add GPUs']")
    private WebElement addGrup;
    @FindBy(css = "#select_348")
    private WebElement numberOfGrup;
    private final By numberOfGrupValue = new By.ByCssSelector("#select_option_353");
    @FindBy(css = "#select_350")
    private WebElement GPUtype;
    private final By GPUtypeNvidia = new By.ByCssSelector("#select_option_360");
    @FindBy(css = "#select_78")
    private WebElement localSSd;
    private final By localSSdValue = new By.ByCssSelector("#select_option_171");
    @FindBy(css = "#select_80")
    private WebElement dataCenreLocation;
    private final By dataCenreLocationValue = new By.ByCssSelector("#select_option_185");
    @FindBy(css = "#select_value_label_52")
    private WebElement commitedUsage;
    private final By commitedUsage1year = new By.ByCssSelector("#select_option_83");
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//div//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimate;
    @FindBy(css = "h2.md-title:nth-child(2) > b:nth-child(1)")
    private WebElement resultOfCointing;

    public GoogleCloudCalculatorBase(WebDriver webDriver) {
        super(webDriver);
    }

    public String getResultOfCointing() {
        return resultOfCointing.getText();
    }

    public void enterFormValues() {

        webDriver.switchTo().frame(frame);
        partComputeEngine.click();
        numberOfInstance.sendKeys("4");
        operationSystem.click();
        findElement(operationSystemElement).click();
        vmClass.click();
        findElement(vmRegular).click();
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();"
                , vmClass);
        machineType.click();
        findElement(machineTypeN1).click();
        addGrup.click();
        numberOfGrup.click();
        findElement(numberOfGrupValue).click();
        GPUtype.click();
        findElement(GPUtypeNvidia).click();
        localSSd.click();
        findElement(localSSdValue).click();
        dataCenreLocation.click();
        findElement(dataCenreLocationValue).click();
        commitedUsage.click();
        findElement(commitedUsage1year).click();
        addToEstimate.click();
    }
}