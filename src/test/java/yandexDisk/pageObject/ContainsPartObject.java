package yandexDisk.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import selenium.base.PageObjectBase;

public class ContainsPartObject extends PageObjectBase {
    private static final String innerHTMLAttribute = "innerHTML";
    private final By publicAccessPageTitle = By.cssSelector(".listing-stub__desc>h1");
    private final By historyPageTitle = By.cssSelector(".journal-filter__header");
    private final By commonPageTitle = By.cssSelector(".listing-heading__title");
    private final By trashCleanButton = By.className("client-listing__clean-trash-button");
    private final By confirmationTrashCleanButton = By.className("js-confirmation-accept");
    private final By packageName = By.className("listing-heading__title");
    private final By deleteButtonLocator = By.className("groupable-buttons__visible-button_name_delete");
    private final static String PACKAGE_SELECTOR_PATTERN = "//div[@class='listing-item__info']//span[text()='%s']/../../..";
    private final static String DOCUMENT_SELECTOR_PATTERN = "//div[@class='listing-item__info']//span[contains(text(),'%s')]/../../..";
    private final MainMenu mainMenu = new MainMenu();

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public String getCommonContainPageTitle() {
        return waitForPresence(commonPageTitle).getAttribute(innerHTMLAttribute);
    }

    public String getPublicAccessContainPageTitle() {
        return waitForPresence(publicAccessPageTitle).getAttribute(innerHTMLAttribute);
    }

    public String getHistoryPageContainPageTitle() {
        return waitForPresence(historyPageTitle).getAttribute(innerHTMLAttribute);
    }

    public ContainsPartObject doubleClickToOpenPack(String name) {
        doubleClickByXPathSelector(String.format(PACKAGE_SELECTOR_PATTERN, name));
        return this;
    }

    public String getPackageName() {
        return waitForVisibility(packageName).getText();
    }

    public CreateNewDocumentPage doubleClickToOpenDoc(String name) {
        doubleClickByXPathSelector(String.format(DOCUMENT_SELECTOR_PATTERN, name));
        return new CreateNewDocumentPage();
    }

    public ContainsPartObject clickCreatedDoc(String name) {
        waitForVisibility(By.xpath(String.format(DOCUMENT_SELECTOR_PATTERN, name))).click();
        return this;
    }

    public ContainsPartObject clickDeleteDocButton() {
        waitForVisibility(deleteButtonLocator).click();
        return this;
    }

    public ContainsPartObject clickButtonToCleanTrash() {
        waitForVisibility(trashCleanButton).click();
        return this;
    }

    public ContainsPartObject clickButtonToConfirmationCleanTrash() {
        waitForVisibility(confirmationTrashCleanButton).click();
        return this;
    }

    public Boolean checkThatDocumentExist(String name) {
        try {
            waitForVisibility(By.xpath(String.format(DOCUMENT_SELECTOR_PATTERN, name)));
            return true;
        } catch (TimeoutException e) {
            return false;
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }
}