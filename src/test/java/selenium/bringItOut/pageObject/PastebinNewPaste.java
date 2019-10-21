package selenium.bringItOut.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.base.PageObjectBase;

public class PastebinNewPaste extends PageObjectBase {

    @FindBy(css = "#selectable>ol")
    private WebElement syntax;
    @FindBy(css = "#paste_code")
    private WebElement pasteText;

    public PastebinNewPaste(WebDriver webDriver) {
        super(webDriver);
    }


    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getCode() {
        return pasteText.getText();
    }

    public String checkBash() {
        return  syntax.getAttribute("class");
    }
}
