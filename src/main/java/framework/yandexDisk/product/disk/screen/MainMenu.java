package framework.yandexDisk.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import framework.screen.PageObjectBase;

public class MainMenu extends PageObjectBase {
    private final By FILE_PAGE_LOCATOR = By.id("/disk");
    private final By TRASH_PAGE_LOCATOR = By.id("/trash");
    private final By PHOTO_PAGE_LOCATOR = By.cssSelector("a[href='/client/photo']");
    private final By GENERAL_ACCESS_PAGE_LOCATOR = By.cssSelector("a[href='/client/shared']");
    private final By HISTORY_PAGE_LOCATOR = By.cssSelector("a[href='/client/journal']");
    private final By ARCHIVE_PAGE_LOCATOR = By.cssSelector("a[href='/client/mail']");
    private final By LAST_PAGE_LOCATOR = By.cssSelector("a[href='/client/recent']");
    private final By CREATE_SOMETHING_NEW_BUTTON_LOCATOR = By.cssSelector(".create-resource-popup-with-anchor>button");
    private final By CREATE_NEW_PACKAGE_BUTTON_LOCATOR = By.xpath("//span[contains(@class, 'file-icon_dir_plus')]/parent::button");
    private final By CREATE_NEW_DOCUMENT_BUTTON_LOCATOR = By.xpath("//span[contains(@class, 'file-icon_doc')]/parent::button");
    private final By NAME_OF_NEW_PACKAGE_INPUT_LOCATOR = By.cssSelector(".rename-dialog__rename-form input");
    private final By SAVE_BUTTON_LOCATOR = By.className("confirmation-dialog__button");

    public ContainsPartObject сlickToGoOnFilePage() {
        highlightElementAndClick(FILE_PAGE_LOCATOR);
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnTrashPage() {
        highlightElementAndClick(TRASH_PAGE_LOCATOR);
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnPhotoPage() {
        highlightElementAndClick(PHOTO_PAGE_LOCATOR);
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnGeneralAccessPage() {
        highlightElementAndClick(GENERAL_ACCESS_PAGE_LOCATOR);
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnHistoryPage() {
        highlightElementAndClick(HISTORY_PAGE_LOCATOR);
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnArchivePage() {
        highlightElementAndClick(ARCHIVE_PAGE_LOCATOR);
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnLastPage() {
        highlightElementAndClick(LAST_PAGE_LOCATOR);
        return new ContainsPartObject();
    }

    public MainMenu clickCreateSMTButton() {
        highlightElementAndClick(CREATE_SOMETHING_NEW_BUTTON_LOCATOR);
        return this;
    }

    public MainMenu clickCreateNewPackageButton() {
        waitForVisibility(CREATE_NEW_PACKAGE_BUTTON_LOCATOR).click();
        return this;
    }

    public MainMenu inputNameOfNewPackage(String name) {
        waitForVisibility(NAME_OF_NEW_PACKAGE_INPUT_LOCATOR).sendKeys(Keys.CONTROL, Keys.SHIFT, Keys.END);
        waitForVisibility(NAME_OF_NEW_PACKAGE_INPUT_LOCATOR).sendKeys(Keys.DELETE);
        highlightElementAndSendText(NAME_OF_NEW_PACKAGE_INPUT_LOCATOR, name);
        return this;
    }

    public ContainsPartObject saveButtonClick() {
        highlightElementAndClick(SAVE_BUTTON_LOCATOR);
        return new ContainsPartObject();
    }

    public CreateNewDocumentPage clickCreateNewDocumentButton() {
        highlightElementAndClick(CREATE_NEW_DOCUMENT_BUTTON_LOCATOR);
        return new CreateNewDocumentPage();
    }
}