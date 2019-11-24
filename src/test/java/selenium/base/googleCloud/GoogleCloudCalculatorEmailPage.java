package selenium.base.googleCloud;

import framework.screen.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudCalculatorEmailPage extends PageObjectBase {
    @FindBy(id = "email_quote")
    private WebElement forSendButton;
    private final By emailAddressInput = new By.ById("input_415");
    private final By sendEmailButton = new By.ByCssSelector("#dialogContent_421 button.cpc-button");

    public GoogleCloudCalculatorEmailPage clickSendEmailButton() {
        forSendButton.click();
        return this;
    }

    public GoogleCloudCalculatorEmailPage enterEmailAddress(String mail) {
        waitForVisibility(emailAddressInput).sendKeys(mail);
        return this;
    }

    public GoogleCloudCalculatorEmailPage scrollToEmailAddress() {
        WebElement buttonForScroll = waitForVisibility(emailAddressInput);
        scrollToElement(buttonForScroll);
        return this;
    }

    public GoogleCloudCalculatorEmailPage sendEmail() {
        waitForVisibility(sendEmailButton).click();
        return this;
    }
}