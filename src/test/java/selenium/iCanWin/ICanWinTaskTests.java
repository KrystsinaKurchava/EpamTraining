package selenium.iCanWin;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


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