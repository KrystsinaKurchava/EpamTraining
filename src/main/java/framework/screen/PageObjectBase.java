package framework.screen;

import framework.util.WebDriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static framework.loger.Log.logger;

public abstract class PageObjectBase {
    protected static final int TIME_OUT_FOR_WAIT = 30;
    private final String SCROLL_ARGUMENT = "arguments[0].scrollIntoView();";

    protected WebDriver webDriver;

    public PageObjectBase() {
        webDriver = WebDriverSingleton.getWebDriver();
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

    protected WebElement waitForVisibility(By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitForPresence(By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected WebElement findVisibleElement(By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void scrollToElement(WebElement webElement) {
        ((JavascriptExecutor) webDriver).executeScript(SCROLL_ARGUMENT, webElement);
    }

    protected WebElement findElementWithText(By by, String text) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        wait.until(ExpectedConditions.textToBe(by, text));
        return webDriver.findElement(by);
    }

    protected Action clickByElement(WebElement element) {
        return new Actions(webDriver)
                .moveToElement(element)
                .click(element)
                .build();
    }

    protected Action enterTextToElement(WebElement element, String text) {
        return new Actions(webDriver)
                .moveToElement(element)
                .click()
                .sendKeys(text)
                .build();
    }

    protected void doubleClickByXPathSelector(String selector) {
        new Actions(webDriver)
                .doubleClick(waitForVisibility(By.xpath(selector)))
                .perform();
    }

    protected void selectText(WebElement element) {
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

    public WebElement highlightElementAndClick(By elementLocator) {
        WebElement element = waitForVisibility(elementLocator);
        String bg = highlightElement(element, "yellow");
        element.click();
        try {
            highlightElement(element, bg);
        } finally {
            return element;
        }
    }

    public WebElement highlightElementAndSendText(By elementLocator, String text) {
        WebElement element = waitForVisibility(elementLocator);
        String bg = highlightElement(element, "yellow");
        clearLine(element);
        element.sendKeys(text);
        try {
            highlightElement(element, bg);
        } finally {
            return element;
        }
    }

    private String highlightElement(WebElement element, String color) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        return bg;
    }

    private void clearLine(WebElement element) {
        element.sendKeys(Keys.CONTROL, Keys.SHIFT, Keys.END);
        element.sendKeys(Keys.DELETE);
    }
}