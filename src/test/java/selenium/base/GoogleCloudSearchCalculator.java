package selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudSearchCalculator extends PageObjectBase {
    @FindBy(css = ".devsite-searchbox>input[name='q']")
    private WebElement searchLine;
    @FindBy(css = "#top-search")
    private WebElement searchForm;

    private final By calculatorLink = new By.ByXPath("//b[text() ='Google Cloud Platform Pricing Calculator']/parent::a");
    public GoogleCloudSearchCalculator(WebDriver webDriver) {
        super(webDriver);
    }

    public void searchForCalculator() {
        searchLine.sendKeys("Google Cloud Platform Pricing Calculator");
        searchForm.submit();
        findElement(calculatorLink).click();


    }
}
