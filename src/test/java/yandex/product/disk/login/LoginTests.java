package yandex.product.disk.login;

import framework.bo.UserFactory;
import framework.yandex.product.disk.screen.StartYandexDiskPage;
import framework.yandex.product.disk.service.YandexDiskService;
import framework.yandex.product.disk.screen.YandexConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import framework.util.WebDriverSingleton;

public class LoginTests extends YandexConditions {
    protected YandexDiskService yandexDiskService;

    @BeforeMethod(description = "Prepare before tests")
    public void browserSetUp() {
        yandexDiskService = new YandexDiskService();
        WebDriverSingleton.getWebDriver().get(LINK_FOR_YANDEX_DISK);
    }

    @AfterMethod(description = "Close browser")
    public void browserClose() {
        WebDriverSingleton.closeDriver();
    }

    @Test(description = "Login with correct username and password")
    public void loginPositive() {
        yandexDiskService.loginYandexDisk(UserFactory.withCredentialsFromProperty());
        Assert.assertTrue(new StartYandexDiskPage().isPersonalCabinetExist(), "Login hasn't done");
    }

    @Test(description = "Login with uncorrected password")
    public void loginNegativeWithEmptyPassword() {
        yandexDiskService.loginYandexDisk(UserFactory.withEmptyPassword());
        Assert.assertEquals(new StartYandexDiskPage().getErrorMessage(), "Пароль не указан", "Didn't get result about empty password");
    }

    @Test(description = "Login with uncorrected username")
    public void loginNegativeWithEmptyUsername() {
        yandexDiskService.loginYandexDiskWithEmptyUsername(UserFactory.withEmptyUsername());
        Assert.assertEquals(new StartYandexDiskPage().getErrorMessage(), "Логин не указан", "Didn't get result about empty username");
    }
}