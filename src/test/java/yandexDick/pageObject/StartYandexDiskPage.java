package yandexDick.pageObject;

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

    public StartYandexDiskPage inputLoginDate(String username) {
        findClickableElement(loginInput).sendKeys(username);
        return this;
    }

    public StartYandexDiskPage inputPasswordLabelClick() {
        findClickableElement(passwordLabelInput)
                .click();
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
