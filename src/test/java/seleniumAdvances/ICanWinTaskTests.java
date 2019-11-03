package seleniumAdvances;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import seleniumAdvances.pageObject.PastebinPageObject;

import java.net.MalformedURLException;
import java.net.URL;

public class ICanWinTaskTests {
    WebDriver webDriver;
    private final String LINK_FOR_PASTERBIN = "https://pastebin.com/";
    private final String NEW_PASTE_TEXT = "Hello from WebDriver";
    private final String PASTE_NAME_TEXT = "helloweb";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("firefox");
        webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                capabilities);
    }

    @AfterTest
    public void tearDown() {
        webDriver.quit();
    }

    @Test(description = "Using JS, Actions")
    public void pastebinNewPaste() {
        webDriver.get(LINK_FOR_PASTERBIN);
        PastebinPageObject page = new PastebinPageObject(webDriver);
        page.createNewPaste(NEW_PASTE_TEXT, PASTE_NAME_TEXT);
        Assert.assertEquals(page.getTextExpected(NEW_PASTE_TEXT), NEW_PASTE_TEXT, "No matches found");
    }
}