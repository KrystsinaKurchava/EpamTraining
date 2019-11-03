package selenium.base.googleCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.PageObjectBase;

public class GoogleCloudCalculatorEmailPage extends PageObjectBase {
    @FindBy(id = "email_quote")
    private WebElement buttonForSent;
    private final By inputEmailAddress = new By.ById("input_415");
    private final By buttonSendEmail = new By.ByCssSelector("#dialogContent_421 button.cpc-button");

    public void buttonToSentEmailClick() {
        buttonForSent.click();
    }

    public void enterEmailAddress(String mail) {
        findClickableElement(inputEmailAddress).sendKeys(mail);
    }

    public void scrollToEmailAddress() {
        WebElement buttonForScroll = findClickableElement(inputEmailAddress);
        scrollToElement(buttonForScroll);
    }

    public void sendEmail() {
        findClickableElement(buttonSendEmail).click();
    }
}