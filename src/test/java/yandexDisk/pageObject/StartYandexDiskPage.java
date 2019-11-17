package yandexDisk.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
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
    private final By enteredUserName = By.className("passp-current-account__display-name");

    public String getErrorMessage() {
        return findVisibleElement(errorText).getText();
    }

    public Boolean isPersonalCabinetExist() {
        try {
            waitForVisibility(profileIcon);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public StartYandexDiskPage waitingForUserName(String userName) {
        findElementWithText(enteredUserName, userName);
        return this;
    }

    public StartYandexDiskPage clickToGoOnLoginPage() {
        waitForVisibility(enterButton).click();
        return this;
    }

    public StartYandexDiskPage inputLoginLabelClick() {
        waitForVisibility(loginLabelInput).click();
        return this;
    }

    public StartYandexDiskPage inputLoginDate(String username) {
        waitForVisibility(loginInput).sendKeys(username);
        return this;
    }

    public StartYandexDiskPage inputPasswordLabelClick() {
        waitForVisibility(passwordLabelInput).click();
        return this;
    }

    public StartYandexDiskPage inputPasswordDate(String password) {
        waitForVisibility(passwordInput).sendKeys(password);
        return this;
    }

    public StartYandexDiskPage clickToSignInButton() {
        waitForVisibility(confirmationPasswordButton).click();
        return this;
    }
}