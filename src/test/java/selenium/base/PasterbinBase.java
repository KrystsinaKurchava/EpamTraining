package selenium.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PasterbinBase extends PageObjectBase {
    @FindBy(id = "paste_code")
    protected WebElement textInNewPasteInput;
    @FindBy(xpath = "//*[@class='select2-selection__rendered' and @title='Never']/..")
    protected WebElement pasteExpirationSelect;
    @FindBy(xpath = "//*[@name='paste_name']")
    protected WebElement pasteNameInput;
    @FindBy(xpath = "//*[@id='submit']")
    protected WebElement forCreateNewPasteButton;

    public abstract void createNewPaste(String textForPaste, String textPasteName);
}