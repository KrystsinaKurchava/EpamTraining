package yandexDisk.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.base.WebDriverSingleton;
import yandexDisk.pageObject.*;
import yandexDisk.service.YandexDiskService;
import yandexDisk.service.UserFactory;

public class ElementsTest extends YandexConditions {
    protected YandexDiskService yandexDiskService;
    private final String NEW_DOCUMENT_TEXT = "Hello world";
    private final String MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE = " page was not found";
    private final String LAST_PAGE_NAME = "Recent files";
    private final String FILE_PAGE_NAME = "Files";
    private final String PHOTO_PAGE_NAME = "All photos";
    private final String GENERAL_ACCESS_PAGE_NAME = "Public links";
    private final String HISTORY_PAGE_NAME = "History";
    private final String ARCHIVE_PAGE_NAME = "Archive";
    private final String TRASH_PAGE_NAME = "Trash";
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
        Assert.assertTrue(new YandexDiskService()
                        .checkButtonsExist(),
                "Some element is not located");
    }

    @Test(description = "Get titles from pages ")
    public void compareTittleAndPage() {
        SoftAssert softAssert = new SoftAssert();
        MainMenu mainMenu = new MainMenu();
        softAssert.assertEquals(mainMenu.сlickToGoOnFilePage()
                        .getCommonTitleContainPage(), FILE_PAGE_NAME,
                FILE_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnLastPage()
                        .getCommonTitleContainPage(), LAST_PAGE_NAME,
                LAST_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnFotoPage()
                        .getPublicAccessTitleContainPage(), PHOTO_PAGE_NAME,
                PHOTO_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnGeneralAccessPage()
                        .getPublicAccessTitleContainPage(), GENERAL_ACCESS_PAGE_NAME,
                GENERAL_ACCESS_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnHistoryPage()
                        .getHistoryPageTitleContainPage(), HISTORY_PAGE_NAME,
                HISTORY_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnArchivePage()
                        .getCommonTitleContainPage(), ARCHIVE_PAGE_NAME,
                ARCHIVE_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnTrashPage()
                        .getCommonTitleContainPage(), TRASH_PAGE_NAME,
                TRASH_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertAll("Title page and button is different");
    }

    @Test(description = "Create new package", priority = 1)
    public void createNewPackage() {
        packageName = yandexDiskService.createNewPackage();
        ContainsPartObject containsPartObject = new ContainsPartObject();
        containsPartObject
                .doubleClickToOpenPack(packageName);
        Assert.assertEquals(containsPartObject.getPackageName(), packageName,
                "Package was not created or inaccessible");
    }

    @Test(description = "Create new document", priority = 2)
    public void createNewDocument() {
        documentName = yandexDiskService.createNewDocument(packageName, NEW_DOCUMENT_TEXT);
        Assert.assertEquals(yandexDiskService.getDocumentText(documentName, packageName), NEW_DOCUMENT_TEXT, "Document saved incorrect");
    }

    @Test(description = "Delete document", priority = 3)
    public void moveDocumentToTrash() {
        yandexDiskService.moveElementInTheTrash(packageName, documentName);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(new ContainsPartObject().checkThatDocumentExist(documentName), "Document didn't delete");
        softAssert.assertTrue(new MainMenu().сlickToGoOnTrashPage().checkThatDocumentExist(documentName), "Document isn't in trash");
        softAssert.assertAll("Unable to move element to trash");
    }

    @Test(description = "Clear trash", priority = 4)
    public void cleanTrashTest() {
        yandexDiskService.cleanTrash();
        Assert.assertFalse(new ContainsPartObject()
                .checkThatDocumentExist(documentName), "Trash not empty");
    }
}