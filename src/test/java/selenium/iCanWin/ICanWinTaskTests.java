package selenium.iCanWin;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.iCanWin.pageObject.PastebinPageObject;


public class ICanWinTaskTests {
    @Test
    public void PastebinNewPaste() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://pastebin.com/");
        PastebinPageObject page = new PastebinPageObject(driver);
        page.createNewPaste();
        driver.quit();
    }
}