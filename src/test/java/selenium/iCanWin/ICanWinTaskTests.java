package selenium.iCanWin;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import selenium.base.PageObjectBase;
import selenium.bringItOut.pageObject.PasterbinsConditions;
import selenium.bringItOut.pageObject.PastebinNewPaste;
import selenium.iCanWin.pageObject.PastebinPageObject;

public class ICanWinTaskTests extends PasterbinsConditions {

    @AfterTest(description = "Closing browser after tests run")
    public void driverClose() {
        PageObjectBase.quit();
    }

    @Test(description = "I can win test")
    public void pastebinNewPaste() {
        PastebinPageObject page = new PastebinPageObject();
        page.goToPage(LINK_FOR_PASTERBIN);
        page.createNewPaste(NEW_PASTE_TEXT, PASTE_NAME_TEXT);
        PastebinNewPaste pastebinNewPaste = new PastebinNewPaste();
        Assert.assertEquals(pastebinNewPaste.getText(), NEW_PASTE_TEXT, "Text is different");
    }
}