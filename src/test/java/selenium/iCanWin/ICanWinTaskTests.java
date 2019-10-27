package selenium.iCanWin;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.bringItOut.pageObject.PastebinNewPaste;
import selenium.iCanWin.pageObject.PastebinPageObject;

public class ICanWinTaskTests {
    WebDriver webDriver;
    private final String LINK_FOR_PASTERBIN = "https://pastebin.com/";
    private final String NEW_PASTE_TEXT = "Hello from WebDriver";
    private final String PASTE_NAME_TEXT = "helloweb";

    @BeforeTest
    public void setUp() {
        webDriver = new FirefoxDriver();
    }

    @AfterTest
    public void tearDown() {
        webDriver.quit();
    }

    @Test  (description = "I can win test")
    public void pastebinNewPaste() {
        webDriver.get(LINK_FOR_PASTERBIN);
        PastebinPageObject page = new PastebinPageObject(webDriver);
        page.createNewPaste(NEW_PASTE_TEXT, PASTE_NAME_TEXT);
        PastebinNewPaste pastebinNewPaste = new PastebinNewPaste(webDriver);
        Assert.assertEquals(NEW_PASTE_TEXT, pastebinNewPaste.getText(), "No matches found");
    }
}