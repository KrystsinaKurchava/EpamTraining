package framework.yandexDisk.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import framework.screen.PageObjectBase;

public class StartYandexDiskPage extends PageObjectBase {
    private final By ENTER_BUTTON_LOCATOR = By.cssSelector(".button_login");
    private final By LOGIN_LABEL_INPUT_LOCATOR = By.className("passp-form-field__label");
    private final By LOGIN_INPUT_LOCATOR = By.id("passp-field-login");
    private final By PASSWORD_LABEL_INPUT_LOCATOR = By.className("passp-form-field__label");
    private final By PASSWORD_INPUT_LOCATOR = By.id("passp-field-passwd");
    private final By CONFIRMATION_PASSWORD_BUTTON_LOCATOR = By.cssSelector(".passp-sign-in-button>button[type='submit']");
    private final By ERROR_TEXT_LOCATOR = By.className("passp-form-field__error");
    private final By PROFILE_ICON_LOCATOR = By.className("user2");
    private final By ENTERED_USER_NAME_LOCATOR = By.className("passp-current-account__display-name");

    public String getErrorMessage() {
        return findVisibleElement(ERROR_TEXT_LOCATOR).getText();
    }

    public Boolean isPersonalCabinetExist() {
        try {
            waitForVisibility(PROFILE_ICON_LOCATOR);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public StartYandexDiskPage waitingForUserName(String userName) {
        findElementWithText(ENTERED_USER_NAME_LOCATOR, userName);
        return this;
    }

    public StartYandexDiskPage clickToGoOnLoginPage() {
        waitForVisibility(ENTER_BUTTON_LOCATOR).click();
        return this;
    }

    public StartYandexDiskPage clickLoginLabelInput() {
        waitForVisibility(LOGIN_LABEL_INPUT_LOCATOR);
        return this;
    }

    public StartYandexDiskPage inputLoginDate(String username) {
        highlightElementAndSendText(LOGIN_INPUT_LOCATOR, username);
        return this;
    }

    public StartYandexDiskPage clickPasswordLabelInput() {
        highlightElementAndClick(PASSWORD_LABEL_INPUT_LOCATOR);
        return this;
    }

    public StartYandexDiskPage inputPasswordDate(String password) {
        highlightElementAndSendText(PASSWORD_INPUT_LOCATOR, password);
        return this;
    }

    public StartYandexDiskPage clickToSignInButton() {
        highlightElementAndClick(CONFIRMATION_PASSWORD_BUTTON_LOCATOR);
        return this;
    }
}