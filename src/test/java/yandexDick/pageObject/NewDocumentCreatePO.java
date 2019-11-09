package yandexDick.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.base.PageObjectBase;

public class NewDocumentCreatePO extends PageObjectBase {
    private final By toTypePlace = By.cssSelector("#WACViewPanel_EditingElement > p:nth-child(1)");
    private final By documentStatus = By.id("BreadcrumbSaveStatus");
    private final By documentTitle = By.id("BreadcrumbTitle");

    public NewDocumentCreatePO typeText(String text) {
        findClickableElement(toTypePlace).sendKeys(text); //wait
        return this;
    }

    public ContainsPartObject returnToYandexPage() {
        Actions builder = new Actions(webDriver);
        builder.keyDown(Keys.CONTROL + "w").keyUp(Keys.CONTROL + "w").build().perform();
        return new ContainsPartObject();
    }

    public NewDocumentCreatePO saveDocument() {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        wait.until(ExpectedConditions.textToBe(documentStatus, "Сохранено в Yandex"));
        webDriver.findElement(documentStatus);
        return this;
    }

    public String getText() {
        return findClickableElement(toTypePlace).getText();
    }

    public NewDocumentCreatePO clickDocumentTitle() {
        findClickableElement(documentTitle).click();
        return this;
    }

    public NewDocumentCreatePO enterDocumentTitle(String text) {
        findClickableElement(documentTitle).sendKeys(text);
        return this;
    }
}
