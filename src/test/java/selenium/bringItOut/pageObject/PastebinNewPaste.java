package selenium.bringItOut.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinNewPaste {
    private WebDriver webDriver;

    @FindBy(css = "#selectable>ol")
    private WebElement syntax;
    @FindBy(css = "#paste_code")
    private WebElement pasteText;

    public PastebinNewPaste(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
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
