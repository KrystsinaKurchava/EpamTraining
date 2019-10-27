package selenium.iCanWin.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.base.PasterbinBase;

public class PastebinPageObject extends PasterbinBase {
    private final By tenMinutesListElement = By.xpath("//li[text()='10 Minutes']");

    public PastebinPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    public void createNewPaste(String textForPaste, String textPasteName) {
        inputTextInNewPaste.sendKeys(textForPaste);
        selectPasteExpiration.click();
        findClickableElement(tenMinutesListElement).click();
        inputPasteName.sendKeys(textPasteName);
        buttonForCreateNewPaste.click();
    }
}