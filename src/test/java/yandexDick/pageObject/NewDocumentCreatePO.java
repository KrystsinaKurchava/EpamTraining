package yandexDick.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import selenium.base.PageObjectBase;

public class NewDocumentCreatePO extends PageObjectBase {
    private final By toTypePlace = By.cssSelector("#WACViewPanel_EditingElement > p:nth-child(1)");

    public NewDocumentCreatePO typeText(String text) {
        findClickableElement(toTypePlace).sendKeys(text); //wait
        return this;
    }

    public ContainsPartObject returnToYandexPage() {
        Actions builder = new Actions(webDriver);
        builder.keyDown(Keys.CONTROL + "w").keyUp(Keys.CONTROL + "w").build().perform();
        return new ContainsPartObject();
    }

    public String getText() {
        return   findClickableElement(toTypePlace).getText();
    }
}
