package yandexDisk.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.base.WebDriverSingleton;
import yandexDisk.pageObject.*;
import yandexDisk.service.YandexDiskService;
import yandexDisk.service.UserCreator;

public class ElementsTest {
    private final String LINK_FOR_YANDEX_DISK = "https://disk.yandex.by/";
    private final String NEW_DOCUMENT_TEXT = "Hello world";
    private final String MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE = " page was not found";
    private final String LAST_PAGE_NAME = "Последние файлы";
    private final String FILE_PAGE_NAME = "Файлы";
    private final String FOTO_PAGE_NAME = "Все фотографии";
    private final String GENERAL_ACCESS_PAGE_NAME = "Публичные ссылки";
    private final String HISTORY_PAGE_NAME = "История";
    private final String ARCHIVE_PAGE_NAME = "Архив";
    private final String TRASH_PAGE_NAME = "Корзина";
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

    @Test(description = "Check locate elements")
    public void checkExistButton() {
        Assert.assertTrue(new YandexDiskService()
                        .checkButtonsExist(),
                "Some element is not located");
    }

    @Test(description = "Get titles from pages ")
    public void compareTittleAndPage() {
        SoftAssert softAssert = new SoftAssert();
        MainMenu mainManu = new MainMenu();
        softAssert.assertEquals(mainManu.сlickToGoOnFilePage()
                        .getCommonTitleContainPage(), FILE_PAGE_NAME,
                FILE_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainManu.сlickToGoOnLastPage()
                        .getCommonTitleContainPage(), LAST_PAGE_NAME,
                LAST_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainManu.сlickToGoOnFotoPage()
                        .getPublicAccessTitleContainPage(), FOTO_PAGE_NAME,
                FOTO_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainManu.сlickToGoOnGeneralAccessPage()
                        .getPublicAccessTitleContainPage(), GENERAL_ACCESS_PAGE_NAME,
                GENERAL_ACCESS_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainManu.сlickToGoOnHistoryPage()
                        .getHistoryPageTitleContainPage(), HISTORY_PAGE_NAME,
                HISTORY_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainManu.сlickToGoOnArchivePage()
                        .getCommonTitleContainPage(), ARCHIVE_PAGE_NAME,
                ARCHIVE_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainManu.сlickToGoOnTrashPage()
                        .getCommonTitleContainPage(), TRASH_PAGE_NAME,
                TRASH_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertAll("Title page and button is different");
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

    @Test(description = "CLear trash", priority = 4)
    public void cleanTrashTest() {
        YandexDiskService service = new YandexDiskService();
        service.cleanTrash();
        Assert.assertFalse(new ContainsPartObject()
                .checkThatDocumentExist(documentName), "Trash not empty");
    }

    @Test(description = "Delete document", priority = 3)
    public void delete() {
        YandexDiskService service = new YandexDiskService();
        documentName = service.createNewDocument("Test", NEW_DOCUMENT_TEXT);
     //   Assert.assertEquals(service.getDocumentText(documentName, packageName), NEW_DOCUMENT_TEXT, "Document saved incorrect");

    }
}