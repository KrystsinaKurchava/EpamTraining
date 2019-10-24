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
    private final String TEXT_FOR_SEARCH_LINE = "Google Cloud Platform Pricing Calculator";

    public GoogleCloudSearchCalculator(WebDriver webDriver) {
        super(webDriver);
    }

    public void searchForCalculator() {
        searchLine.sendKeys(TEXT_FOR_SEARCH_LINE);
        searchForm.submit();
        findElement(calculatorLink).click();
    }
}