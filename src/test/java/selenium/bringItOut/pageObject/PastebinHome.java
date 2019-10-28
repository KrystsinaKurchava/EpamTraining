package selenium.bringItOut.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.PasterbinBase;

public class PastebinHome extends PasterbinBase {
    @FindBy(xpath = "//*[@class='select2-selection__rendered' and @title ='None']")
    private WebElement selectSyntax;
    private final By tenMinutesListElement = new By.ByXPath("//li[text() = '10 Minutes']");
    private final By bashListElement = new By.ByXPath("//li[text() = 'Bash']");

    public PastebinHome(WebDriver webDriver) {
        super(webDriver);
    }

    public void createNewPaste(String textForPaste, String textPasteName) {
        inputTextInNewPaste.sendKeys(textForPaste);
        selectSyntax.click();
        findClickableElement(bashListElement).click();
        selectPasteExpiration.click();
        findClickableElement(tenMinutesListElement).click();
        inputPasteName.sendKeys(textPasteName);
        buttonForCreateNewPaste.click();
    }
}