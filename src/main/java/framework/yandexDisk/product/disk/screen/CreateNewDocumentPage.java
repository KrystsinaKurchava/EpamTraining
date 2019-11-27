package framework.yandexDisk.product.disk.screen;

import framework.screen.PageObjectBase;
import org.openqa.selenium.By;

public class CreateNewDocumentPage extends PageObjectBase {
    private final By TO_TYPE_PLACE_LOCATOR = By.id("WACViewPanel_EditingElement");
    private final By DOCUMENT_STATUS_LOCATOR = By.id("BreadcrumbSaveStatus");
    private final By CLOSE_BUTTON_LOCATOR = By.id("btnjClose-Menu32");
    private final By FRAME_LOCATOR = By.tagName("iframe");
    private final By FILE_MENU_BUTTON_LOCATOR = By.cssSelector("button[data-unique-id='FileMenu']");
    private final By RENAME_BUTTON_LOCATOR = By.id("jbtnRenameDialog-Menu48");
    private final By DOCUMENT_TITTLE_INPUT_LOCATOR = By.id("txtDocumentName");
    private final By CONFIRMATION_DOCUMENT_TITTLE_BUTTON_LOCATOR = By.id("WACDialogActionButton");
    private final By DOCUMENT_TITLE_TEXT_LOCATOR = By.id("BreadcrumbTitle");
    private final String EXPECTED_CONDITION_TEXT = "Saved to Yandex";

    public CreateNewDocumentPage switchToMainIFrame() {
        webDriver.switchTo().frame(waitForPresence(FRAME_LOCATOR));
        return this;
    }

    public CreateNewDocumentPage clickTextInput() {
        highlightElementAndClick(TO_TYPE_PLACE_LOCATOR);
        return this;
    }

    public CreateNewDocumentPage clickExitButton() {
        highlightElementAndClick(CLOSE_BUTTON_LOCATOR);
        return this;
    }

    public CreateNewDocumentPage typeText(String text) {
        highlightElementAndSendText(TO_TYPE_PLACE_LOCATOR, text);
        return this;
    }

    public CreateNewDocumentPage saveDocument() {
        findElementWithText(DOCUMENT_STATUS_LOCATOR, EXPECTED_CONDITION_TEXT);
        return this;
    }

    public String getDocumentText() {
        return waitForVisibility(TO_TYPE_PLACE_LOCATOR).getText();
    }

    public CreateNewDocumentPage clickFileMenuButton() {
        highlightElementAndClick(FILE_MENU_BUTTON_LOCATOR);
        return this;
    }

    public CreateNewDocumentPage clickRenameButton() {
        highlightElementAndClick(RENAME_BUTTON_LOCATOR);
        return this;
    }

    public CreateNewDocumentPage enterDocumentTitle(String text) {
        highlightElementAndSendText(DOCUMENT_TITTLE_INPUT_LOCATOR, text);
        return this;
    }

    public CreateNewDocumentPage clickConfirmationDocumentTittleButton() {
        highlightElementAndClick(CONFIRMATION_DOCUMENT_TITTLE_BUTTON_LOCATOR);
        return this;
    }

    public CreateNewDocumentPage waitForTitleChanging(String title) {
        findElementWithText(DOCUMENT_TITLE_TEXT_LOCATOR, title);
        return this;
    }
}