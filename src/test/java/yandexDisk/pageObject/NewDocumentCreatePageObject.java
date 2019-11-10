package yandexDisk.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.base.PageObjectBase;

public class NewDocumentCreatePageObject extends PageObjectBase {
    private final By toTypePlace = By.id("WACViewPanel_EditingElement");
    private final By documentStatus = By.id("BreadcrumbSaveStatus");
    private final By closeButton = By.id("btnjClose-Menu32");
    private final By frame = By.tagName("iframe");
    private final By сloseFileButton = By.id("jbtnBackArrow-Menu32");
    private final String EXPECTED_CONDITION_TEXT = "Сохранено в Yandex";
    private final By fileMenuButton = By.cssSelector("button[data-unique-id='FileMenu']");
    private final By renameButton = By.id("jbtnRenameDialog-Menu48");
    private final By documentTittleInput = By.id("txtDocumentName");
    private final By confirmationDocumentTittleInput = By.id("WACDialogActionButton");

    public NewDocumentCreatePageObject switchToMainIFrame() {
        webDriver.switchTo().frame(findPresenceElement(frame));
        return this;
    }

    public NewDocumentCreatePageObject clickTextInput() {
        findClickableElement(toTypePlace).click();
        return this;
    }

    public NewDocumentCreatePageObject clickCloseButton() {
        findClickableElement(closeButton).click();
        return this;
    }

    public NewDocumentCreatePageObject clickExitButton() {
        findClickableElement(closeButton).click();
        return this;
    }

    public NewDocumentCreatePageObject typeText(String text) {
        findClickableElement(toTypePlace).sendKeys(text);
        return this;
    }

    public NewDocumentCreatePageObject saveDocument() {
        WebDriverWait wait = new WebDriverWait(webDriver, TIME_OUT_FOR_WAIT);
        wait.until(ExpectedConditions.textToBe(documentStatus, EXPECTED_CONDITION_TEXT));
        webDriver.findElement(documentStatus);
        return this;
    }

    public String getText() {
        return findClickableElement(toTypePlace).getText();
    }

    public NewDocumentCreatePageObject clickFileMenuButton() {
        findClickableElement(fileMenuButton).click();
        return this;
    }

    public NewDocumentCreatePageObject clickRenameButton() {
        findClickableElement(renameButton).click();
        return this;
    }

    public NewDocumentCreatePageObject enterDocumentTitle(String text) {
        findClickableElement(documentTittleInput).clear();
        findClickableElement(documentTittleInput).sendKeys(text);
        findClickableElement(confirmationDocumentTittleInput).click();
        return this;
    }

    public NewDocumentCreatePageObject clickCloseFileMenuButton() {
        findClickableElement(сloseFileButton).click();
        return this;
    }
}