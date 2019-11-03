package seleniumAdvances.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PasterbinBase extends PageObjectBase {
    @FindBy(id = "paste_code")
    protected WebElement inputTextInNewPaste;
    @FindBy(xpath = "//*[@class='select2-selection__rendered' and @title='Never']/..")
    protected WebElement selectPasteExpiration;
    @FindBy(xpath = "//*[@name='paste_name']")
    protected WebElement inputPasteName;
    @FindBy(xpath = "//*[@id='submit']")
    protected WebElement buttonForCreateNewPaste;

    public abstract void createNewPaste(String textForPaste, String textPasteName);
}