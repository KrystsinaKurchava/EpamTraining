package selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObjectBase {
    protected WebDriver webDriver;
    private final int TIME_OUT_FOR_WAIT = 30;
    private final String SCROLL_ARGUMENT = "arguments[0].scrollIntoView();";

    public PageObjectBase(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected WebElement findClickableElement(By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return webDriver.findElement(by);
    }

    protected void scrollToElement(WebElement webElement) {
        ((JavascriptExecutor) webDriver).executeScript(SCROLL_ARGUMENT, webElement);
    }
}