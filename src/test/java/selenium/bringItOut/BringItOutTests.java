package selenium.bringItOut;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.bringItOut.pageObject.PastebinHome;
import selenium.bringItOut.pageObject.PastebinNewPaste;

public class BringItOutTests {
    private static WebDriver webDriver;

    @Before
    public void before() {
        webDriver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void taskTask() {
        webDriver.get("https://pastebin.com/");
        PastebinHome pastebinHome = new PastebinHome(webDriver);
        pastebinHome.createNewPaste();
        PastebinNewPaste pastebinNewPaste = new PastebinNewPaste(webDriver);

    Assert.assertEquals("[Bash] how to gain dominance among developers - Pastebin.com",
            pastebinNewPaste.getTitle());

    Assert.assertEquals("git config --global user.name" +
                    "  \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m " +
                    "\"Legacy code\")\n" +
                    "git push origin master --force",
            pastebinNewPaste.getCode());

    Assert.assertEquals("bash",
          pastebinNewPaste.checkBash());
    }
}