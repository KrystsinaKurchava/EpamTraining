package framework.test.yandex.product.disk.login;

import framework.yandexDisk.product.disk.screen.MainMenu;
import framework.bo.UserFactory;
import framework.yandexDisk.product.disk.service.YandexDiskService;
import framework.yandexDisk.product.disk.screen.YandexConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import framework.util.WebDriverSingleton;

public class ClickButtonTest extends YandexConditions {
    protected YandexDiskService yandexDiskService;
    private final String MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE = " page was not found";
    private final String LAST_PAGE_NAME = "Recent files";
    private final String FILE_PAGE_NAME = "Files";
    private final String PHOTO_PAGE_NAME = "All photos";
    private final String GENERAL_ACCESS_PAGE_NAME = "Public links";
    private final String HISTORY_PAGE_NAME = "History";
    private final String ARCHIVE_PAGE_NAME = "Archive";
    private final String TRASH_PAGE_NAME = "Trash";

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
        Assert.assertTrue(yandexDiskService.isButtonExist(),
                "Some element is not located");
    }

    @Test(description = "Get titles from pages ")
    public void compareTittleAndPage() {
        SoftAssert softAssert = new SoftAssert();
        MainMenu mainMenu = new MainMenu();
        softAssert.assertEquals(mainMenu.сlickToGoOnFilePage()
                        .getCommonContainPageTitle(), FILE_PAGE_NAME,
                FILE_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnLastPage()
                        .getCommonContainPageTitle(), LAST_PAGE_NAME,
                LAST_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnPhotoPage()
                        .getPublicAccessContainPageTitle(), PHOTO_PAGE_NAME,
                PHOTO_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnGeneralAccessPage()
                        .getPublicAccessContainPageTitle(), GENERAL_ACCESS_PAGE_NAME,
                GENERAL_ACCESS_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnHistoryPage()
                        .getHistoryPageContainPageTitle(), HISTORY_PAGE_NAME,
                HISTORY_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnArchivePage()
                        .getCommonContainPageTitle(), ARCHIVE_PAGE_NAME,
                ARCHIVE_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertEquals(mainMenu.сlickToGoOnTrashPage()
                        .getCommonContainPageTitle(), TRASH_PAGE_NAME,
                TRASH_PAGE_NAME + MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE);
        softAssert.assertAll("Title page and button is different");
    }
}