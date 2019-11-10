package yandexDick.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium.base.PageObjectBase;

public class ContainsPartObject extends PageObjectBase {
    private static final String innerHTMLAttribute = "innerHTML";
    private final By pagePublicAccessTitle = By.cssSelector(".listing-stub__desc>h1");
    private final By pageHistoryTitle = By.cssSelector(".journal-filter__header");
    private final By pageTitleCommon = By.cssSelector(".listing-heading__title");
    private final By createdPackageOrDocument = By.cssSelector("div.listing-item:nth-child(1)");
    private final By trashCleanButton = By.className("client-listing__clean-trash-button");
    private final By confirmationTrashCleanButton = By.className("js-confirmation-accept");

    public String getCommonTitleContainPage() {
        return findPresenceElement(pageTitleCommon).getAttribute(innerHTMLAttribute);
    }

    public String getPublicAccessTitleContainPage() {
        return findPresenceElement(pagePublicAccessTitle).getAttribute(innerHTMLAttribute);
    }

    public String getHistoryPageTitleContainPage() {
        return findPresenceElement(pageHistoryTitle).getAttribute(innerHTMLAttribute);
    }

    public ContainsPartObject doubleClickToOpenPack(String name) {
        doubleClickByXPathSelector("//div[@class='listing-item__info']//span[text()='" + name + "']/../../..");
        return this;
    }

    public String getPackageName() {
        By nameOfDoc = By.className("listing-heading__title");
        return findClickableElement(nameOfDoc).getText();
    }

    public NewDocumentCreatePO doubleClickToOpenDoc(String name) {
        doubleClickByXPathSelector("//div[@class='listing-item__info']//span[contains(text(),'" + name + "')]/../../..");
        return new NewDocumentCreatePO();
    }

    private void doubleClickByXPathSelector(String selector) {
        WebElement asd = findClickableElement(By.xpath(selector));
        new Actions(webDriver)
              //  .moveToElement(asd)
                .doubleClick(asd)
                .perform();
    }

    public WebElement findCreatedDoc(String name) {
        By nameOfDoc = By.xpath("//div[@class='listing-item__info']//span[contains(text(),'" + name + "')]/../../..");
        return findClickableElement(nameOfDoc);
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
        By nameOfDoc = By.cssSelector("//div[@class='listing-item__info']//span[text()='" + name + "']/../../..");
        try {
            findClickableElement(nameOfDoc);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
