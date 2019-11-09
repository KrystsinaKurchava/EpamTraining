package yandexDick.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.base.PageObjectBase;

public class StartYandexDiskPage extends PageObjectBase {
    private final By enterButton = By.cssSelector("a.button:nth-child(2)");
    private final By loginLabelInput = By.className("passp-form-field__label");
    private final By loginInput = By.id("passp-field-login");
    private final By passwordLabelInput = By.className("passp-form-field__label");
    private final By passwordInput = By.id("passp-field-passwd");
    private final By confirmationLoginButton = By.cssSelector("button.button2_theme_action:nth-child(1)");
    private final By confirmationPasswordButton = By.cssSelector("button.control:nth-child(1)");

    public String errorMessage() {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        By error = By.className("passp-form-field__error");
        wait.until(ExpectedConditions.visibilityOfElementLocated(error));
        return webDriver.findElement(error).getText();
    }
    public Boolean checkPersonalCabinetExist(){
        By nameOfDoc = By.className("user2");
        try {
            findClickableElement(nameOfDoc);
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

    public StartYandexDiskPage inputLoginClick() {
        findClickableElement(loginInput).click();
        return this;
    }

    public StartYandexDiskPage inputLoginDate(String username) {
        findClickableElement(loginInput).sendKeys(username);
        return this;
    }

    public StartYandexDiskPage clickToConfirmationLoginButton() {
        findClickableElement(confirmationLoginButton).click();
        return this;
    }

    public StartYandexDiskPage inputPasswordLabelClick() {
        findClickableElement(passwordLabelInput)
                .click();
        return this;
    }

    public StartYandexDiskPage inputPasswordClick() {
        findClickableElement(passwordInput)
                .click();
        return this;
    }

    public StartYandexDiskPage inputPasswordDate(String password) {
        findClickableElement(passwordInput).sendKeys(password);
        return this;
    }

    public StartYandexDiskPage clickToConfirmationPasswordButton() {
        findClickableElement(confirmationPasswordButton).click();
        return this;
    }
}
