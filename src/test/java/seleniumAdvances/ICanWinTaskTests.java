package seleniumAdvances;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import selenium.base.PageObjectBase;
import selenium.bringItOut.pageObject.PasterbinsConstants;
import seleniumAdvances.pageObject.PastebinPageObjectAdvances;

public class ICanWinTaskTests extends PasterbinsConstants {


    @AfterTest(description = "Closing browser after tests run")
    public void driverClose() {
        PageObjectBase.quit();
    }

    @Test(description = "Using JS, Actions")
    public void pastebinNewPaste() {
        PastebinPageObjectAdvances page = new PastebinPageObjectAdvances();
        page.goToPage(LINK_FOR_PASTERBIN);
        page.createNewPaste(NEW_PASTE_TEXT, PASTE_NAME_TEXT);
        Assert.assertEquals(page.getTextExpected(NEW_PASTE_TEXT), NEW_PASTE_TEXT, "No matches found");
    }
}