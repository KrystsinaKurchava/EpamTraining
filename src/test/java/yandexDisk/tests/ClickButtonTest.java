package yandexDisk.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.base.WebDriverSingleton;
import yandexDisk.pageObject.MainMenu;
import yandexDisk.service.ScreenShots;
import yandexDisk.service.UserCreator;
import yandexDisk.service.YandexDiskService;

@Listeners({ScreenShots.class})
public class ClickButtonTest extends YandexConditions {
    private final String MESSAGE_FOR_CASE_WITHOUT_COINCIDENCE = " page was not found";
    private final String LAST_PAGE_NAME = "Последние файлы";
    private final String FILE_PAGE_NAME = "Файлы";
    private final String PHOTO_PAGE_NAME = "Все фотографии";
    private final String GENERAL_ACCESS_PAGE_NAME = "Публичные ссылки";
    private final String HISTORY_PAGE_NAME = "История";
    private final String ARCHIVE_PAGE_NAME = "Архив";
    private final String TRASH_PAGE_NAME = "Корзина";

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
}