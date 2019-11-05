package selenium.iCanWin.pageObject;

import org.openqa.selenium.By;
import selenium.base.PasterbinBase;

public class PastebinPageObject extends PasterbinBase {
    private final By tenMinutesListElement = By.xpath("//li[text()='10 Minutes']");

    @Override
    public void createNewPaste(String textForPaste, String textPasteName) {
        textInNewPasteInput.sendKeys(textForPaste);
        pasteExpirationSelect.click();
        findClickableElement(tenMinutesListElement).click();
        pasteNameInput.sendKeys(textPasteName);
        forCreateNewPasteButton.click();
    }
}