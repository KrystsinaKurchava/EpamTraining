package selenium.hardcore.pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.base.GoogleCloudCalculatorBase;
import selenium.base.PageObjectBase;

import javax.swing.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Set;


public class TrickEmailAddress extends PageObjectBase {
    private String mailPageHandler;
    private By  inputEmailAddress = new By.ByCssSelector("#mailAddress");
    private By  expanderEmailText = new By.ByCssSelector("#messagesList");
    private By  cellMoney = new By.ByCssSelector(".quote > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > h3:nth-child(1)");

    public TrickEmailAddress(WebDriver webDriver, String previousPageHandler) {
        super(webDriver);

        ((JavascriptExecutor) webDriver).executeScript("window.open(\"https://10minutemail.com/\")");
        Set<String> handles = webDriver.getWindowHandles();
        for (String handler : handles)
            if (!previousPageHandler.equals(handler)) {
                mailPageHandler = handler;
            }
    }
    public void switchToMailWindow() {
        webDriver.switchTo().window(mailPageHandler);
    }

    public String createNewEmail() {
        return findElement(inputEmailAddress).getAttribute("value");
    }

    public String getRentCost() {
        this.switchToMailWindow();
        WebDriverWait wait = new WebDriverWait(webDriver, 5000);
        wait.until(ExpectedConditions.elementToBeClickable(expanderEmailText)).click();
        return findElement(cellMoney).getText();
    }
}
