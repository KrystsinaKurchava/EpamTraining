package selenium.base.googleCloud;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.base.PageObjectBase;

import java.util.Set;

public class TrickEmailsPage extends PageObjectBase {
    private By inputEmailAddress = new By.ById("mailAddress");
    private By expanderEmailText = new By.ById("messagesList");
    private By cellMoney = new By.ByCssSelector(".quote td:last-child h3");
    private final String ATTRIBUTE_VALUE = "value";
    private final String EXECUTE_SCRIPT = "window.open(\"https://10minutemail.com/\")";
    private final int EMAIL_WAITING_TIMEOUT_IN_SECONDS = 5000;

    public TrickEmailsPage(WebDriver webDriver) {
        super(webDriver);

    }

    public String openMailPage(String previousPageHandler) {
        ((JavascriptExecutor) webDriver).executeScript(EXECUTE_SCRIPT);
        Set<String> handles = webDriver.getWindowHandles();
        for (String handler : handles)
            if (!previousPageHandler.equals(handler)) {
                return handler;
            }
        return previousPageHandler;
    }

    public String createNewEmail() {
        return findClickableElement(inputEmailAddress).getAttribute(ATTRIBUTE_VALUE);
    }

    public void scrollToInputEmailAddress() {
        WebElement buttonForScroll = findClickableElement(inputEmailAddress);
        scrollToElement(buttonForScroll);
    }

    public void waitForAppearanceExpanderToMail() {
        WebDriverWait wait = new WebDriverWait(webDriver, EMAIL_WAITING_TIMEOUT_IN_SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(expanderEmailText)).click();
    }

    public String getMoneyValue() {
        return findClickableElement(cellMoney).getText();
    }
}