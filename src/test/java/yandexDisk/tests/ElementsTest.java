package yandexDisk.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.base.WebDriverSingleton;
import yandexDisk.pageObject.*;
import yandexDisk.service.ScreenShots;
import yandexDisk.service.YandexDiskService;
import yandexDisk.service.UserCreator;

@Listeners({ScreenShots.class})
public class ElementsTest extends YandexConditions {
    private final String NEW_DOCUMENT_TEXT = "Hello world";
    private String packageName;
    private String documentName;

    @BeforeMethod(description = "Prepare page before tests")
    public void browserSetUp() {
        WebDriverSingleton.getWebDriver().get(LINK_FOR_YANDEX_DISK);
        new YandexDiskService().loginYandexDisk(UserCreator.withCredentialsFromProperty());
    }

    @AfterMethod(description = "Close browser")
    public void browserClose() {
        WebDriverSingleton.closeDriver();
    }

    @Test(description = "Create new package", priority = 1)
    public void createNewPackageTest() {
        packageName = new YandexDiskService().createNewPackage();
        new ContainsPartObject()
                .doubleClickToOpenPack(packageName);
        Assert.assertEquals(new ContainsPartObject()
                        .getPackageName(), packageName,
                "Package was not created or inaccessible");
    }

    @Test(description = "Create new document", priority = 2)
    public void createNewDocumentTest() {
        YandexDiskService service = new YandexDiskService();
        documentName = service.createNewDocument(packageName, NEW_DOCUMENT_TEXT);
        Assert.assertEquals(service.getDocumentText(documentName, packageName), NEW_DOCUMENT_TEXT, "Document saved incorrect");
    }

    @Test(description = "Delete document", priority = 3)
    public void moveDocumentToTrashTest() {
        YandexDiskService service = new YandexDiskService();
        service.moveElementInTheTrash(packageName, documentName);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(new ContainsPartObject().checkThatDocumentExist(documentName), "Document didn't delete");
        softAssert.assertTrue(new MainMenu().сlickToGoOnTrashPage().checkThatDocumentExist(documentName), "Document isn't in trash");
        softAssert.assertAll("Unable to move element to trash");
    }

//    @Test(description = "Clear trash", priority = 4)
//    public void cleanTrashTest() {
//        YandexDiskService service = new YandexDiskService();
//        service.cleanTrash();
//        Assert.assertFalse(new ContainsPartObject()
//                .checkThatDocumentExist(documentName), "Trash not empty");
//    }
}