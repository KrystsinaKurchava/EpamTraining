package selenium.bringItOut.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.PasterbinBase;

public class PastebinHome extends PasterbinBase {
    @FindBy(xpath = "//*[@class='select2-selection__rendered' and @title ='None']")
    private WebElement selectSyntax;
    private final By tenMinutesListElement = new By.ByXPath("//li[text() = '10 Minutes']");
    private final By bashListElement = new By.ByXPath("//li[text() = 'Bash']");

    @Override
    public void createNewPaste(String textForPaste, String textPasteName) {
        textInNewPasteInput.sendKeys(textForPaste);
        selectSyntax.click();
        waitForVisibility(bashListElement).click();
        pasteExpirationSelect.click();
        waitForVisibility(tenMinutesListElement).click();
        pasteNameInput.sendKeys(textPasteName);
        forCreateNewPasteButton.click();
    }
}