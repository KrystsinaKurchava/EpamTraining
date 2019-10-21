package selenium.iCanWin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.base.PasterbinBase;

public class PastebinPageObject extends PasterbinBase {

    private final By tenMinutesListElement = By.xpath("//li[text()='10 Minutes']");
    private final String newPasteText = "Hello from WebDriver";
    private final String pasteNameText = "helloweb";

    public PastebinPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    public void createNewPaste() {
        inputTextInNewPaste.sendKeys(newPasteText);
        selectPasteExpiration.click();
        findElement(tenMinutesListElement).click();
        inputPasteName.sendKeys(pasteNameText);
        buttonForCreateNewPaste.click();
    }



}