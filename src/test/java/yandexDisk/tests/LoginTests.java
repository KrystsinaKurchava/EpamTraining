package yandexDisk.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.base.WebDriverSingleton;
import yandexDisk.pageObject.*;
import yandexDisk.service.ScreenShots;
import yandexDisk.service.YandexDiskService;
import yandexDisk.service.UserCreator;

@Listeners({ScreenShots.class})
public class LoginTests extends YandexConditions {

    @BeforeMethod(description = "Prepare before tests")
    public void browserSetUp() {
        WebDriverSingleton.getWebDriver().get(LINK_FOR_YANDEX_DISK);
    }

    @AfterMethod(description = "Close browser")
    public void browserClose() {
        WebDriverSingleton.closeDriver();
    }

    @Test(description = "Login with correct username and password")
    public void loginPositiveTest() {
        new YandexDiskService().loginYandexDisk(UserCreator.withCredentialsFromProperty());
        Assert.assertTrue(new StartYandexDiskPage().checkPersonalCabinetExist(), "Login hasn't done");
    }

    @Test(description = "Login with uncorrected password")
    public void loginNegativeWithEmptyPasswordTest() {
        new YandexDiskService().loginYandexDisk(UserCreator.withEmptyPassword());
        Assert.assertEquals(new StartYandexDiskPage().errorMessage(), "Пароль не указан", "Invalid result(password should be empty)");
    }

    @Test(description = "Login with uncorrected username")
    public void loginNegativeWithEmptyUsernameTest() {
        new YandexDiskService().loginYandexDiskWithEmptyUsername(UserCreator.withEmptyUsername());
        Assert.assertEquals(new StartYandexDiskPage().errorMessage(), "Логин не указан", "Invalid result (username should be empty)");
    }
}