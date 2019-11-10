package yandexDisk.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.base.PageObjectBase;

public class StartYandexDiskPage extends PageObjectBase {
    private final By enterButton = By.cssSelector(".button_login");
    private final By loginLabelInput = By.className("passp-form-field__label");
    private final By loginInput = By.id("passp-field-login");
    private final By passwordLabelInput = By.className("passp-form-field__label");
    private final By passwordInput = By.id("passp-field-passwd");
    private final By confirmationPasswordButton = By.cssSelector(".passp-sign-in-button>button[type='submit']");
    private final By errorText = By.className("passp-form-field__error");
    private final By profileIcon = By.className("user2");

    public String errorMessage() {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorText));
        return webDriver.findElement(errorText).getText();
    }

    public Boolean checkPersonalCabinetExist() {
        try {
            findClickableElement(profileIcon);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public StartYandexDiskPage clickToGoOnLoginPage() {
        findClickableElement(enterButton).click();
        return this;
    }

    public StartYandexDiskPage inputLoginLabelClick() {
        findClickableElement(loginLabelInput).click();
        return this;
    }

    public StartYandexDiskPage inputLoginDate(String username) {
        findClickableElement(loginInput).sendKeys(username);
        return this;
    }

    public StartYandexDiskPage inputPasswordLabelClick() {
        findClickableElement(passwordLabelInput).click();
        return this;
    }

    public StartYandexDiskPage inputPasswordDate(String password) {
        findClickableElement(passwordInput).sendKeys(password);
        return this;
    }

    public StartYandexDiskPage clickToSignInButton() {
        findClickableElement(confirmationPasswordButton).click();
        return this;
    }
}