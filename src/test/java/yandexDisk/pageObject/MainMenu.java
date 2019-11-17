package yandexDisk.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import selenium.base.PageObjectBase;

public class MainMenu extends PageObjectBase {
    private final By filePage = By.id("/disk");
    private final By trashPage = By.id("/trash");
    private final By photoPage = By.cssSelector("a[href='/client/photo']");
    private final By generalAccessPage = By.cssSelector("a[href='/client/shared']");
    private final By historyPage = By.cssSelector("a[href='/client/journal']");
    private final By archivePage = By.cssSelector("a[href='/client/mail']");
    private final By lastPage = By.cssSelector("a[href='/client/recent']");
    private final By createSomethingNewButton = By.cssSelector(".create-resource-popup-with-anchor>button");
    private final By createNewPackageButton = By.xpath("//span[contains(@class, 'file-icon_dir_plus')]/parent::button");
    private final By createNewDocumentButton = By.xpath("//span[contains(@class, 'file-icon_doc')]/parent::button");
    private final By nameOfNewPackageInput = By.cssSelector(".rename-dialog__rename-form input");
    private final By saveButton = By.className("confirmation-dialog__button");

    public ContainsPartObject сlickToGoOnFilePage() {
        waitForVisibility(filePage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnTrashPage() {
        waitForVisibility(trashPage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnPhotoPage() {
        waitForVisibility(photoPage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnGeneralAccessPage() {
        waitForVisibility(generalAccessPage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnHistoryPage() {
        waitForVisibility(historyPage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnArchivePage() {
        waitForVisibility(archivePage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnLastPage() {
        waitForVisibility(lastPage).click();
        return new ContainsPartObject();
    }

    public MainMenu clickCreateSMTButton() {
        waitForVisibility(createSomethingNewButton).click();
        return this;
    }

    public MainMenu clickCreateNewPackageButton() {
        waitForVisibility(createNewPackageButton).click();
        return this;
    }

    public MainMenu inputNameOfNewPackage(String name) {
        waitForVisibility(nameOfNewPackageInput).sendKeys(Keys.CONTROL, Keys.SHIFT, Keys.END);
        waitForVisibility(nameOfNewPackageInput).sendKeys(Keys.DELETE);
        waitForVisibility(nameOfNewPackageInput).sendKeys(name);
        return this;
    }

    public ContainsPartObject saveButtonClick() {
        waitForVisibility(saveButton).click();
        return new ContainsPartObject();
    }

    public CreateNewDocumentPage clickCreateNewDocumentButton() {
        waitForVisibility(createNewDocumentButton).click();
        return new CreateNewDocumentPage();
    }
}