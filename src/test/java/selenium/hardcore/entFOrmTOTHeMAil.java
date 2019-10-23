package selenium.hardcore;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.base.GoogleCloudCalculatorBase;

import javax.swing.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Set;


public class entFOrmTOTHeMAil extends GoogleCloudCalculatorBase {
    private String mailPageHandler;
    @FindBy(css = "#email_quote")
    private WebElement buttonForSent;
    @FindBy(css = "#mailAddress")
    private WebElement mail;

    @FindBy(css = "md-dialog-actions.layout-row > button:nth-child(2)")
    private WebElement buttonForSentEmail;

    private String email;
    @FindBy(css = "h2.md-title:nth-child(2) > b:nth-child(1)")
    private WebElement resultOfCointing;
    // private By mail = new By.ByCssSelector("#mailAddress");
public void sentToTheMAil(){
    buttonForSent.click();
}
public void swithToMailWindow() {

    webDriver.switchTo().window(mailPageHandler);
}
public String  createNewEmail(){

  return  mail.getAttribute("value");

}
    public void  inputEmail(String mail) {

    findElement(  new By.ByCssSelector("#input_364"  )).sendKeys(mail);
buttonForSentEmail.click();
    }



public String compare(){

    WebDriverWait wait = new WebDriverWait(webDriver, 5000);
    this.swithToMailWindow();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".inc-mail-address"))).click();
return findElement(By.cssSelector(".quote > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > h3:nth-child(1)")).getText();
}
    public Boolean getResultOfCointing() {
        return resultOfCointing.getText().contains(this.compare());
    }

public entFOrmTOTHeMAil(WebDriver webDriver, String parent_handle) {
        super(webDriver);

    ((JavascriptExecutor) webDriver).executeScript("window.open(\"https://10minutemail.com/\")");
    Set<String> handles = webDriver.getWindowHandles();
    System.out.println(handles);
    for(String handle1:handles)
        if(!parent_handle.equals(handle1))
        {
            mailPageHandler=handle1;
        }


    }
}
