package selenium.bringItOut.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.PageObjectBase;

public class PastebinNewPaste extends PageObjectBase {
    @FindBy(css = "#selectable>ol")
    private WebElement syntax;
    @FindBy(id = "paste_code")
    private WebElement pasteText;
    private final String ATTRIBUTE_FOR_CHECK = "class";

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getText() {
        return pasteText.getText();
    }

    public String checkBash() {
        return syntax.getAttribute(ATTRIBUTE_FOR_CHECK);
    }
}