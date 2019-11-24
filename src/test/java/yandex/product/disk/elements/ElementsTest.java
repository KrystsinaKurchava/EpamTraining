package yandex.product.disk.elements;

import framework.bo.UserFactory;
import framework.yandex.product.disk.screen.ContainsPartObject;
import framework.yandex.product.disk.screen.MainMenu;
import framework.yandex.product.disk.service.YandexDiskService;
import framework.yandex.product.disk.screen.YandexConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import framework.util.WebDriverSingleton;

public class ElementsTest extends YandexConditions {
    private final String NEW_DOCUMENT_TEXT = "Hello world";
    protected YandexDiskService yandexDiskService;
    private String packageName;
    private String documentName;

    @BeforeMethod(description = "Prepare page before tests")
    public void loginIntoYandexDisk() {
        WebDriverSingleton.getWebDriver().get(LINK_FOR_YANDEX_DISK);
        yandexDiskService = new YandexDiskService();
        yandexDiskService.loginYandexDisk(UserFactory.withCredentialsFromProperty());
    }

    @AfterMethod(description = "Close browser")
    public void browserClose() {
        WebDriverSingleton.closeDriver();
    }

    @Test(description = "Check locate elements")
    public void checkExistButton() {
        Assert.assertTrue(new YandexDiskService().isButtonExist(),
                "Some element is not located");
    }

    @Test(description = "Create new package", priority = 1)
    public void createNewPackage() {
        packageName = yandexDiskService.createNewPackage();
        ContainsPartObject containsPartObject = new ContainsPartObject();
        containsPartObject.doubleClickToOpenPack(packageName);
        Assert.assertEquals(containsPartObject.getPACKAGE_NAME_LOCATOR(), packageName,
                "Package was not created or inaccessible");
    }

    @Test(description = "Create new document", priority = 2)
    public void createNewDocument() {
        documentName = yandexDiskService.createNewDocument(packageName, NEW_DOCUMENT_TEXT);
        Assert.assertEquals(yandexDiskService.getDocumentText(documentName, packageName),
                NEW_DOCUMENT_TEXT, "Document saved incorrect");
    }

    @Test(description = "Delete document", priority = 3)
    public void moveDocumentToTrash() {
        yandexDiskService.moveElementInTheTrash(packageName, documentName);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(new ContainsPartObject().checkThatDocumentExist(documentName),
                "Document didn't delete");
        softAssert.assertTrue(new MainMenu().сlickToGoOnTrashPage().checkThatDocumentExist(documentName),
                "Document isn't in trash");
        softAssert.assertAll("Unable to move element to trash");
    }

    @Test(description = "Clear trash", priority = 4)
    public void cleanTrashTest() {
        yandexDiskService.cleanTrash();
        Assert.assertFalse(new ContainsPartObject().checkThatDocumentExist(documentName),
                "Trash not empty");
    }
}