package seleniumAdvances.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
        clickByElement(findClickableElement(tenMinutesListElement)).perform();
        enterTextToElement(textInNewPasteInput, textForPaste).perform();
        enterTextToElement(pasteNameInput, textPasteName).perform();
        highlightElement(notice);
        clickButtonWithJS(forCreateNewPasteButton);
    }

    private Action clickByElement(WebElement element) {
        return new Actions(webDriver)
                .moveToElement(element)
                .click(element)
                .build();
    }

    private Action enterTextToElement(WebElement element, String text) {
        return new Actions(webDriver)
                .moveToElement(element)
                .click()
                .sendKeys(text)
                .build();
    }

    protected void highlightElement(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("\n" +
                "      rng = document.createRange();\n" +
                "      rng.selectNode(arguments[0])\n" +
                "      sel = window.getSelection();\n" +
                "      sel.removeAllRanges();\n" +
                "      sel.addRange(rng);", element);
    }

    protected void clickButtonWithJS(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", element);
    }

    public String getTextExpected(String expectedText) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        wait.until(ExpectedConditions.textToBePresentInElement(textInNewPasteInput, expectedText));
        return textInNewPasteInput.getText();
    }
}