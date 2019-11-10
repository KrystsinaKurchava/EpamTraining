package yandexDick.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.base.PageObjectBase;

public class NewDocumentCreatePO extends PageObjectBase {
    private final By toTypePlace = By.id("WACViewPanel_EditingElement");
    private final By documentStatus = By.id("BreadcrumbSaveStatus");
    private final By documentTitle = By.id("BreadcrumbTitle");
    private final By closeButton = By.id("btnjClose-Menu32");
    private final By frame = By.tagName("iframe");


    public NewDocumentCreatePO switchToMainIFrame() {
        webDriver.switchTo().frame(findPresenceElement(frame));
        return this;
    }

    public NewDocumentCreatePO clickTextInput() {
        findClickableElement(toTypePlace).click();
        return this;
    }

    public NewDocumentCreatePO clickCloseButton() {
        findClickableElement(closeButton).click();
        return this;
    }

    public NewDocumentCreatePO typeText(String text) {
        findClickableElement(toTypePlace).sendKeys(text);
        return this;
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

    public NewDocumentCreatePO clickFileMenuButton() {
        findClickableElement(By.cssSelector("button[data-unique-id='FileMenu']")).click();
        return this;
    }

    public NewDocumentCreatePO clickRenameButton() {
        findClickableElement(By.id("jbtnRenameDialog-Menu48")).click();
        return this;
    }

    public NewDocumentCreatePO enterDocumentTitle(String text) {
        findClickableElement(By.id("txtDocumentName")).clear();
        findClickableElement(By.id("txtDocumentName")).sendKeys(text);
        findClickableElement(By.id("WACDialogActionButton")).click();
        return this;
    }
}
