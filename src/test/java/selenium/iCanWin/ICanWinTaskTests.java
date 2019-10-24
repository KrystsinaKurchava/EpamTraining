package selenium.iCanWin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.iCanWin.pageObject.PastebinPageObject;

public class ICanWinTaskTests {
    WebDriver webDriver;
    private final String LINK_FOR_PASTERBIN = "https://pastebin.com/";

    @Before
    public void before() {
        webDriver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void PastebinNewPaste() {
        webDriver.get(LINK_FOR_PASTERBIN);
        PastebinPageObject page = new PastebinPageObject(webDriver);
        page.createNewPaste();
    }
}