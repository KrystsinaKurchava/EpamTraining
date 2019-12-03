package seleniumAdvances.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.base.PasterbinBase;

public class PastebinPageObjectAdvances extends PasterbinBase {
    private final By tenMinutesListElement = By.xpath("//li[text()='10 Minutes']");
    @FindBy(id = "notice")
    private WebElement notice;

    @Override
    public void createNewPaste(String textForPaste, String textPasteName) {
        clickByElement(pasteExpirationSelect).perform();
        clickByElement(waitForVisibility(tenMinutesListElement)).perform();
        enterTextToElement(textInNewPasteInput, textForPaste).perform();
        enterTextToElement(pasteNameInput, textPasteName).perform();
        selectText(notice);
        clickButtonWithJS(forCreateNewPasteButton);
    }

    public String getTextExpected(String expectedText) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        wait.until(ExpectedConditions.textToBePresentInElement(textInNewPasteInput, expectedText));
        return textInNewPasteInput.getText();
    }
}