package selenium.bringItOut;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.base.PageObjectBase;
import selenium.bringItOut.pageObject.PastebinHome;
import selenium.bringItOut.pageObject.PastebinNewPaste;
import selenium.bringItOut.pageObject.PasterbinsConditions;

public class BringItOutTests extends PasterbinsConditions {

    private final String TEXT_FOR_PASTE = "git config --global user.name" +
            "  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m " +
            "\"Legacy code\")\n" +
            "git push origin master --force";
    private final String TEXT_PASTE_NAME = "how to gain dominance among developers";

    @AfterTest(description = "Closing browser after tests run")
    public void driverClose() {
        PageObjectBase.quit();
    }

    @Test(description = "Bring It Out Test")
    public void pastebinNewPaste() {
        PastebinHome pastebinHome = new PastebinHome();
        pastebinHome.goToPage(LINK_FOR_PASTERBIN);
        pastebinHome.createNewPaste(TEXT_FOR_PASTE, TEXT_PASTE_NAME);
        PastebinNewPaste pastebinNewPaste = new PastebinNewPaste();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(pastebinNewPaste.getTitle(), "[Bash] how to gain dominance among developers - Pastebin.com",
                "Page title is unexpected");
        softAssert.assertEquals(pastebinNewPaste.getText(), "git config --global user.name" +
                        "  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m " +
                        "\"Legacy code\")\n" +
                        "git push origin master --force",
                "The content of the text is different");
        softAssert.assertEquals(pastebinNewPaste.checkBash(), "bash",
                "Bash does not match");
        softAssert.assertAll("Bring it out test failed");
    }
}