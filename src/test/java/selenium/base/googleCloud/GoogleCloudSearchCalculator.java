package selenium.base.googleCloud;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.PageObjectBase;

public class GoogleCloudSearchCalculator extends PageObjectBase {
    @FindBy(css = ".devsite-searchbox>input[name='q']")
    private WebElement searchLine;
    @FindBy(id = "top-search")
    private WebElement searchForm;

    public GoogleCloudSearchResult startSearch() {
        searchForm.submit();
        return new GoogleCloudSearchResult();
    }

    public GoogleCloudSearchCalculator enterSearchLine(String text) {
        searchLine.sendKeys(text);
        return new GoogleCloudSearchCalculator();
    }
}