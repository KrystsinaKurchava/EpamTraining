package selenium.base;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class PageObjectBase {
    protected static WebDriver webDriver;
    protected static final int TIME_OUT_FOR_WAIT = 30;
    private final String SCROLL_ARGUMENT = "arguments[0].scrollIntoView();";

    static {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("firefox");
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        webDriver.manage().timeouts().pageLoadTimeout(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
    }

    public PageObjectBase() {
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

    public static void quit() {
        webDriver.quit();
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