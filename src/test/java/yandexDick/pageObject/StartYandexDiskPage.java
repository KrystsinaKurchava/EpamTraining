package yandexDick.pageObject;

import org.openqa.selenium.By;
import selenium.base.PageObjectBase;

public class StartYandexDiskPage extends PageObjectBase {
    private final By enterButton = By.cssSelector("a.button:nth-child(2)");
    private final By loginInput = By.id("passp-field-login");
    private final By passwordInput = By.id("passp-field-passwd");
    private final By confirmationLoginButton = By.cssSelector("button.button2_theme_action:nth-child(1)");
    private final By confirmationPasswordButton = By.cssSelector("button.control:nth-child(1)");


    public StartYandexDiskPage clickToGoOnLoginPage() {
        findClickableElement(enterButton).click();
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
