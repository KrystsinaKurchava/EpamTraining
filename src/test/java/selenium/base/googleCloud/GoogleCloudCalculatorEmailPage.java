package selenium.base.googleCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.PageObjectBase;

public class GoogleCloudCalculatorEmailPage extends PageObjectBase {
    @FindBy(id = "email_quote")
    private WebElement forSendButton;
    private final By emailAddressInput = new By.ById("input_415");
    private final By sendEmailButton = new By.ByCssSelector("#dialogContent_421 button.cpc-button");

    public void clickSendEmailButton() {
        forSendButton.click();
    }

    public void enterEmailAddress(String mail) {
        findClickableElement(emailAddressInput).sendKeys(mail);
    }

    public void scrollToEmailAddress() {
        WebElement buttonForScroll = findClickableElement(emailAddressInput);
        scrollToElement(buttonForScroll);
    }

    public void sendEmail() {
        findClickableElement(sendEmailButton).click();
    }
}