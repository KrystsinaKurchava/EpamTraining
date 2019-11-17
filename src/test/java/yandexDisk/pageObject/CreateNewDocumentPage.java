package yandexDisk.pageObject;

import org.openqa.selenium.By;
import selenium.base.PageObjectBase;

public class CreateNewDocumentPage extends PageObjectBase {
    private final By toTypePlace = By.id("WACViewPanel_EditingElement");
    private final By documentStatus = By.id("BreadcrumbSaveStatus");
    private final By closeButton = By.id("btnjClose-Menu32");
    private final By frame = By.tagName("iframe");
    private final By fileMenuButton = By.cssSelector("button[data-unique-id='FileMenu']");
    private final By renameButton = By.id("jbtnRenameDialog-Menu48");
    private final By documentTittleInput = By.id("txtDocumentName");
    private final By confirmationDocumentTittleButton = By.id("WACDialogActionButton");
    private final By documentTitleText = By.id("BreadcrumbTitle");
    private final String EXPECTED_CONDITION_TEXT = "Сохранено в Yandex";

    public CreateNewDocumentPage switchToMainIFrame() {
        webDriver.switchTo().frame(waitForPresence(frame));
        return this;
    }

    public CreateNewDocumentPage clickTextInput() {
        waitForVisibility(toTypePlace).click();
        return this;
    }

    public CreateNewDocumentPage clickExitButton() {
        waitForVisibility(closeButton).click();
        return this;
    }

    public CreateNewDocumentPage typeText(String text) {
        waitForVisibility(toTypePlace).sendKeys(text);
        return this;
    }

    public CreateNewDocumentPage saveDocument() {
        findElementWithText(documentStatus, EXPECTED_CONDITION_TEXT);
        return this;
    }

    public String getDocumentText() {
        return waitForVisibility(toTypePlace).getText();
    }

    public CreateNewDocumentPage clickFileMenuButton() {
        waitForVisibility(fileMenuButton).click();
        return this;
    }

    public CreateNewDocumentPage clickRenameButton() {
        waitForVisibility(renameButton).click();
        return this;
    }

    public CreateNewDocumentPage enterDocumentTitle(String text) {
        waitForVisibility(documentTittleInput).clear();
        waitForVisibility(documentTittleInput).sendKeys(text);
        return this;
    }

    public CreateNewDocumentPage clickConfirmationDocumentTittleButton() {
        waitForVisibility(confirmationDocumentTittleButton).click();
        return this;
    }

    public CreateNewDocumentPage waitForTitleChanging(String title) {
        findElementWithText(documentTitleText, title);
        return this;
    }
}