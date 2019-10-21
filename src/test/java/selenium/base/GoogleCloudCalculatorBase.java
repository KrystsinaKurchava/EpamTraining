package selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudCalculatorBase extends PageObjectBase {

    @FindBy(css = ".hexagon-in2")
    private WebElement partComputeEngine;
    @FindBy(css = "#input_53")
    private WebElement numberOfInstance;
    @FindBy(css = "#select_65")
   //click
    private WebElement operationSystem;
    //click
    private final By operationSystemElement = new By.ByCssSelector("#select_option_55");


    @FindBy(css = "#select_69")
    private WebElement vmClass;
    private final By vmRegular = new By.ByCssSelector("#select_option_67");


    @FindBy(css = "#select_76")
    private WebElement machineType;
    private final By machineTypeN1 = new By.ByCssSelector("#select_option_217");
    @FindBy(css = "md-checkbox.ng-touched")
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

    public GoogleCloudCalculatorBase(WebDriver webDriver) {
        super(webDriver);
    }

    public void EnterFormValues(){
        /*. Заполнить форму следующими данными:
         * Number of instances: 4
         * What are these instances for?: оставить пустым
         * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
         * VM Class: Regular
         * Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
         * Выбрать Add GPUs
         * Number of GPUs: 1
         * GPU type: NVIDIA Tesla V100
         * Local SSD: 2x375 Gb
         * Datacenter location: Frankfurt (europe-west3)
         * Commited usage: 1 Year
            7. Нажать Add to Estimate
         * */
    }

}
