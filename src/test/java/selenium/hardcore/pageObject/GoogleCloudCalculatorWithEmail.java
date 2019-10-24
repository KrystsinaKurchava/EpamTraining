package selenium.hardcore.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.GoogleCloudCalculatorBase;

public class GoogleCloudCalculatorWithEmail extends GoogleCloudCalculatorBase {
    @FindBy(css = "#email_quote")
    private WebElement buttonForSent;
    private final By inputEmailAddress = new By.ByCssSelector("#input_415");
    private final By buttonSendEmail = new By.ByCssSelector("#dialogContent_421 button.cpc-button");

    public GoogleCloudCalculatorWithEmail(WebDriver webDriver) {
        super(webDriver);
    }

    public void sendEmail(String mail) {
        buttonForSent.click();
        findElement(inputEmailAddress).sendKeys(mail);
        WebElement buttonForScroll = findElement(inputEmailAddress);
        scrollToElement(buttonForScroll);
        findElement(buttonSendEmail).click();
    }
}