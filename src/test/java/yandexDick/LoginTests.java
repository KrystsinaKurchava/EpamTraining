package yandexDick;

import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.base.WebDriverSingleton;
import yandexDick.pageObject.*;

public class LoginTests {
    private final String LINK_FOR_YANDEX_DISK = "https://disk.yandex.by/";

    @BeforeMethod(description = "")
    public void browserSetUp() {
        WebDriverSingleton.getWebDriver().get(LINK_FOR_YANDEX_DISK);
    }

    @AfterMethod(description = "")
    public void browserClose() {
        WebDriverSingleton.closeDriver();
    }

    @Test(description = "")
    public void loginPositiveTest() {
        new Service().loginYandexDisk(UserCreator.withCredentialsFromProperty());
        Assert.assertTrue(new StartYandexDiskPage().checkPersonalCabinetExist(), "Login hasn't done");
    }

    @Test(description = "")
    public void loginNegativeWithEmptyPasswordTest() {
        new Service().loginYandexDisk(UserCreator.withEmptyPassword());
        Assert.assertEquals(new StartYandexDiskPage().errorMessage(), "Пароль не указан","Invalid result(password should be empty)");
    }

    @Test(description = "")
    public void loginNegativeWithEmptyUsernameTest() {
        new Service().loginYandexDisk(UserCreator.withEmptyUsername());
        Assert.assertEquals(new StartYandexDiskPage().errorMessage(), "Логин не указан","Invalid result (username should be empty)");
    }
    }