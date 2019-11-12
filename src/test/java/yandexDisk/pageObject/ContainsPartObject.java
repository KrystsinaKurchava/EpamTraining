package yandexDisk.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public String getCommonTitleContainPage() {
        return findPresenceElement(commonPageTitle).getAttribute(innerHTMLAttribute);
    }

    public String getPublicAccessTitleContainPage() {
        return findPresenceElement(publicAccessPageTitle).getAttribute(innerHTMLAttribute);
    }

    public String getLastTitlePage() {
        return findPresenceElement(By.cssSelector(".listing__items>.listing__group-title")).getAttribute(innerHTMLAttribute);
    }


    public String getHistoryPageTitleContainPage() {
        return findPresenceElement(historyPageTitle).getAttribute(innerHTMLAttribute);
    }

    public ContainsPartObject doubleClickToOpenPack(String name) {
        doubleClickByXPathSelector("//div[@class='listing-item__info']//span[text()='" + name + "']/../../..");
        return this;
    }

    public String getPackageName() {
        return findClickableElement(packageName).getText();
    }

    public NewDocumentCreatePageObject doubleClickToOpenDoc(String name) {
        doubleClickByXPathSelector("//div[@class='listing-item__info']//span[contains(text(),'" + name + "')]/../../..");
        return new NewDocumentCreatePageObject();
    }

    private void doubleClickByXPathSelector(String selector) {
        WebElement webElement = findClickableElement(By.xpath(selector));
        new Actions(webDriver)
                .doubleClick(webElement)
                .perform();
    }

    public WebElement findCreatedDoc(String name) {
        By nameOfDocument = By.xpath("//div[@class='listing-item__info']//span[contains(text(),'" + name + "')]/../../..");
        return findClickableElement(nameOfDocument);
    }

    public ContainsPartObject clickCreatedDoc(String name) {
        By nameOfDoc = By.xpath("//div[@class='listing-item__info']//span[contains(text(),'" + name + "')]/../../..");
        findClickableElement(nameOfDoc).click();
        return this;
    }

    public ContainsPartObject clickDeleteDocButton() {
        By nameOfDoc = By.className("groupable-buttons__visible-button_name_delete");
        findClickableElement(nameOfDoc).click();
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
        By nameOfDocument = By.cssSelector("//div[@class='listing-item__info']//span[text()='" + name + "']/../../..");
        try {
            findClickableElement(nameOfDocument);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}