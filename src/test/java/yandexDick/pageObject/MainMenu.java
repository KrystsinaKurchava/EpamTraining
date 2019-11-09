package yandexDick.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.base.PageObjectBase;

public class MainMenu extends PageObjectBase {
    private final By filePage = By.cssSelector("#\\/disk");
    private final By trachPage = By.cssSelector("#\\/trash");
    private final By fotoPage = By.cssSelector("a[href='/client/photo']");
    private final By generalAccessPage = By.cssSelector("a[href='/client/published']");
    private final By historyPage = By.cssSelector(".navigation__link_current");
    private final By archivePage = By.cssSelector("a[href='/client/mail']");
    private final By lastPage = By.cssSelector("a[href='/client/recent']");

    private final By createSomethingNewButton = By.cssSelector("button.button2_tone_default:nth-child(1)");
    private final By createNewPackageButton = By.cssSelector("button.create-resource-button:nth-child(1)");
    private final By createNewDocumentButton = By.cssSelector("button.create-resource-button:nth-child(2)");
    private final By nameOfNewPackageInput = By.cssSelector("input.textinput__control:nth-child(1)");
    private final By saveButton = By.cssSelector("button.button2_size_m:nth-child(1)");

    public ContainsPartObject сlickToGoOnFilePage() {
        findClickableElement(filePage).click();
        return new ContainsPartObject();
    }

    public ContainsPartObject сlickToGoOnTrachPage() {
        findClickableElement(trachPage).click();
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
        findClickableElement(nameOfNewPackageInput).sendKeys(name);
        return this;
    }

    public ContainsPartObject  saveButtonClick() {
        findClickableElement(saveButton).click();
        return new ContainsPartObject();
    }

    public NewDocumentCreatePO clickCreateNewDocumentButton() {
        findClickableElement(createNewDocumentButton).click();
    return new NewDocumentCreatePO();
    }
    public WebElement getTrashAddress(){
       return findClickableElement(trachPage);
            }
}
