package yandexDisk.pageObject;

import org.openqa.selenium.By;
import selenium.base.PageObjectBase;

public class NewDocumentCreatePageObject extends PageObjectBase {
    private final By toTypePlace = By.id("WACViewPanel_EditingElement");
    private final By documentStatus = By.id("BreadcrumbSaveStatus");
    private final By closeButton = By.id("btnjClose-Menu32");
    private final By frame = By.tagName("iframe");
    private final By closeFileButton = By.id("jbtnBackArrow-Menu32");
    private final String EXPECTED_CONDITION_TEXT = "Сохранено в Yandex";
    private final By fileMenuButton = By.cssSelector("button[data-unique-id='FileMenu']");
    private final By renameButton = By.id("jbtnRenameDialog-Menu48");
    private final By documentTittleInput = By.id("txtDocumentName");
    private final By confirmationDocumentTittleButton = By.id("WACDialogActionButton");
    private final By documentTitleText = By.id("BreadcrumbTitle");

    public NewDocumentCreatePageObject switchToMainIFrame() {
        webDriver.switchTo().frame(findPresenceElement(frame));
        return this;
    }

    public NewDocumentCreatePageObject clickTextInput() {
        findClickableElement(toTypePlace).click();
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
        findElementWithText(documentStatus, EXPECTED_CONDITION_TEXT);
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
        return this;
    }

    public NewDocumentCreatePageObject clickConfirmationDocumentTittleButton() {
        findClickableElement(confirmationDocumentTittleButton).click();
        return this;
    }

    public NewDocumentCreatePageObject waitForTitleChanging(String title) {
        findElementWithText(documentTitleText, title);
        return this;
    }

    public NewDocumentCreatePageObject clickCloseFileMenuButton() {
        findClickableElement(closeFileButton).click();
        return this;
    }
}