package selenium.bringItOut;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.bringItOut.pageObject.PastebinHome;
import selenium.bringItOut.pageObject.PastebinNewPaste;

import java.util.concurrent.TimeUnit;

public class BringItOutTests {
    private static WebDriver webDriver;
    private final String LINK_TO_PASTEBIN = "https://pastebin.com/";
    private final String TEXT_FOR_PASTE = "git config --global user.name" +
            "  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m " +
            "\"Legacy code\")\n" +
            "git push origin master --force";
    private final String TEXT_PASTE_NAME = "how to gain dominance among developers";
    private final int TIME_WAITING_PAGE = 30;

    @BeforeTest
    public void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(TIME_WAITING_PAGE, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TIME_WAITING_PAGE, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        webDriver.quit();
    }

    @Test(description = "Bring It Out Test")
    public void pastebinNewPaste() {
        webDriver.get(LINK_TO_PASTEBIN);
        PastebinHome pastebinHome = new PastebinHome(webDriver);
        pastebinHome.createNewPaste(TEXT_FOR_PASTE, TEXT_PASTE_NAME);
        PastebinNewPaste pastebinNewPaste = new PastebinNewPaste(webDriver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("[Bash] how to gain dominance among developers - Pastebin.com",
                pastebinNewPaste.getTitle());
        softAssert.assertEquals("git config --global user.name" +
                        "  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m " +
                        "\"Legacy code\")\n" +
                        "git push origin master --force",
                pastebinNewPaste.getText());
        softAssert.assertEquals("bash",
                pastebinNewPaste.checkBash());
        softAssert.assertAll("No matches found");
    }
}