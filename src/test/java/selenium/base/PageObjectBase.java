package selenium.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public abstract class PageObjectBase {
    protected static final int TIME_OUT_FOR_WAIT = 30;
    private final String SCROLL_ARGUMENT = "arguments[0].scrollIntoView();";

    protected   WebDriver webDriver;

    public PageObjectBase() {
        webDriver= WebDriverSingleton.getWebDriver();
        PageFactory.initElements(webDriver, this);
    }

    public void goToPage(String url) {
        webDriver.get(url);
    }

    public void switchToWindow(String handler) {
        webDriver.switchTo().window(handler);
    }

    public String getCurrentWindowHandler() {
        return webDriver.getWindowHandle();
    }

    public String getOtherWindowHandler() {
        String previousPageHandler = getCurrentWindowHandler();
        Set<String> handles = webDriver.getWindowHandles();
        for (String handler : handles)
            if (!previousPageHandler.equals(handler)) {
                return handler;
            }
        return previousPageHandler;
    }

    public static void quit() {
        WebDriverSingleton.getWebDriver().quit();
       }

    protected WebElement findClickableElement(By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return webDriver.findElement(by);
    }

    protected WebElement findPresenceElement(By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webDriver.findElement(by);
    }

    protected void scrollToElement(WebElement webElement) {
        ((JavascriptExecutor) webDriver).executeScript(SCROLL_ARGUMENT, webElement);
    }
}