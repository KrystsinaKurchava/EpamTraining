package selenium.iCanWin.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.base.PasterbinBase;

public class PastebinPageObject extends PasterbinBase {

    private final By tenMinutesListElement = By.xpath("//li[text()='10 Minutes']");
    private final String NEW_PASTE_TEXT = "Hello from WebDriver";
    private final String PASTE_NAME_TEXT = "helloweb";

    public PastebinPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    public void createNewPaste() {
        inputTextInNewPaste.sendKeys(NEW_PASTE_TEXT);
        selectPasteExpiration.click();
        findElement(tenMinutesListElement).click();
        inputPasteName.sendKeys(PASTE_NAME_TEXT);
        buttonForCreateNewPaste.click();
    }
}