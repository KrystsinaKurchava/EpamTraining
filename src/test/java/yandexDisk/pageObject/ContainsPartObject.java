package yandexDisk.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
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
    private final static String PACKAGE_SELECTOR = "//div[@class='listing-item__info']//span[text()='%s']/../../..";
    private final static String DOCUMENT_SELECTOR = "//div[@class='listing-item__info']//span[contains(text(),'%s')]/../../..";

    public String getCommonTitleContainPage() {
        return findPresenceElement(commonPageTitle).getAttribute(innerHTMLAttribute);
    }

    public String getPublicAccessTitleContainPage() {
        return findPresenceElement(publicAccessPageTitle).getAttribute(innerHTMLAttribute);
    }

    public String getHistoryPageTitleContainPage() {
        return findPresenceElement(historyPageTitle).getAttribute(innerHTMLAttribute);
    }

    public ContainsPartObject doubleClickToOpenPack(String name) {
        doubleClickByXPathSelector(String.format(PACKAGE_SELECTOR, name));
        return this;
    }

    public String getPackageName() {
        return findClickableElement(packageName).getText();
    }

    public NewDocumentCreatePageObject doubleClickToOpenDoc(String name) {
        doubleClickByXPathSelector(String.format(DOCUMENT_SELECTOR, name));
        return new NewDocumentCreatePageObject();
    }

    private void doubleClickByXPathSelector(String selector) {
        new Actions(webDriver)
                .doubleClick(findClickableElement(By.xpath(selector)))
                .perform();
    }

    public ContainsPartObject clickCreatedDoc(String name) {
        findClickableElement(By.xpath(String.format(DOCUMENT_SELECTOR, name))).click();
        return this;
    }

    public ContainsPartObject clickDeleteDocButton() {
        findClickableElement(deleteButtonLocator).click();
        return this;
    }

    public ContainsPartObject clickButtonToCleanTrash() {
        findClickableElement(trashCleanButton).click();
        return this;
    }

    public ContainsPartObject clickButtonToConfirmationCleanTrash() {
        findClickableElement(confirmationTrashCleanButton).click();
        return this;
    }

    public Boolean checkThatDocumentExist(String name) {
        try {
            findClickableElement(By.xpath(String.format(DOCUMENT_SELECTOR, name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}