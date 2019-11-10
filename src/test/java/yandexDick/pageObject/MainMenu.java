package yandexDick.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import selenium.base.PageObjectBase;

public class MainMenu extends PageObjectBase {
    private final By filePage = By.id("/disk");
    private final By trashPage = By.id("/trash");
    private final By fotoPage = By.cssSelector("a[href='/client/photo']");
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
        findClickableElement(filePage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnTrashPage() {
        findClickableElement(trashPage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnFotoPage() {
        findClickableElement(fotoPage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnGeneralAccessPage() {
        findClickableElement(generalAccessPage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnHistoryPage() {
        findClickableElement(historyPage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnArchivePage() {
        findClickableElement(archivePage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnLastPage() {
        findClickableElement(lastPage).click();
        return new ContainsPartObject();
    }

    public MainMenu clickCreateSMTButton() {
        findClickableElement(createSomethingNewButton).click();
        return this;
    }

    public MainMenu clickCreateNewPackageButton() {
        findClickableElement(createNewPackageButton).click();
        return this;
    }

    public MainMenu inputNameOfNewPackage(String name) {
        findClickableElement(nameOfNewPackageInput).clear();
        findClickableElement(nameOfNewPackageInput).sendKeys(name);
        return this;
    }

    public ContainsPartObject saveButtonClick() {
        findClickableElement(saveButton).click();
        return new ContainsPartObject();
    }

    public NewDocumentCreatePO clickCreateNewDocumentButton() {
        findClickableElement(createNewDocumentButton).click();
        return new NewDocumentCreatePO();
    }

    public WebElement getTrashAddress() {
        return findClickableElement(trashPage);
    }
}
