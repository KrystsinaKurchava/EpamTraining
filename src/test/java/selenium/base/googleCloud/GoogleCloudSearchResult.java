package selenium.base.googleCloud;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.PageObjectBase;

public class GoogleCloudSearchResult extends PageObjectBase {
    @FindBy(xpath = "//b[text() ='Google Cloud Platform Pricing Calculator']/parent::a")
    private WebElement calculatorLink;

    public GoogleCloudCalculatorPage goToTheCalculatorLink() {
        calculatorLink.click();
        return new GoogleCloudCalculatorPage();
    }
}