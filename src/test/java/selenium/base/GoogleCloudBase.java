package selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  GoogleCloudBase {
    private WebDriver webDriver;
    @FindBy(css = ".devsite-searchbox>input[name='q']")
private WebElement searchLine;

    private WebElement buttonForSearch;


    private WebElement platformPricingCalculator;

    @FindBy(css = ".hexagon-in2")
    private WebElement partComputeEngine;
    @FindBy(css = "#input_53")
    private WebElement numberOfInstance;
    @FindBy(css = "#select_value_label_46")
   //click
    private WebElement operationSystem;
    //click
    private final By operationSystemElement = new By.ByCssSelector("#select_option_55");


    @FindBy(css = "#select_value_label_47")
    private WebElement vmClass;
    private final By vmRegular = new By.ByCssSelector("#select_option_67");


    @FindBy(css = "#select_value_label_49")
    private WebElement machineType;
    private final By machineTypeN1 = new By.ByCssSelector("#select_option_217");
    @FindBy(css = "md-checkbox.ng-touched")
    private WebElement addGrup;

    @FindBy(css = "#select_value_label_346")
    private WebElement numberOfGrup;
    private final By numberOfGrupValue = new By.ByCssSelector("#select_option_368");

    @FindBy(css = "#select_value_label_347")
    private WebElement GPUtype;
    private final By GPUtypeNvidia = new By.ByCssSelector("#select_option_360");

    @FindBy(css = "#select_value_label_347")
    private WebElement localSSd;
    private final By localSSdValue = new By.ByCssSelector("#select_option_360");

    @FindBy(css = "#select_value_label_347")
    private WebElement dataCenreLocation;
    private final By dataCenreLocationValue = new By.ByCssSelector("#select_option_360")

    @FindBy(css = "#select_value_label_347")
    private WebElement commitedUsage;
    private final By commitedUsage1year = new By.ByCssSelector("#select_option_360")







    public GoogleCloudBase(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, true);
    }
}
