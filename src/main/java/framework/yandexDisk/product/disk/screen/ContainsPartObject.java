package framework.yandexDisk.product.disk.screen;

import framework.screen.PageObjectBase;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;

public class ContainsPartObject extends PageObjectBase {
    private static final String INNER_HTML_ATTRIBUTE = "innerHTML";
    private final By PUBLIC_ACCESS_PAGE_TITLE_LOCATOR = By.cssSelector(".listing-stub__desc>h1");
    private final By HISTORY_PAGE_TITTLE_LOCATOR = By.cssSelector(".journal-filter__header");
    private final By COMMON_PAGE_TITTLE_LOCATOR = By.cssSelector(".listing-heading__title");
    private final By TRASH_CLEAN_BUTTON_LOCATOR = By.className("client-listing__clean-trash-button");
    private final By CONFIRMATION_TRASH_CLEAN_BUTTON_LOCATOR = By.className("js-confirmation-accept");
    private final By PACKAGE_NAME_LOCATOR = By.className("listing-heading__title");
    private final By DELETE_BUTTON_LOCATOR = By.className("groupable-buttons__visible-button_name_delete");
    private final static String PACKAGE_SELECTOR_PATTERN = "//div[@class='listing-item__info']//span[text()='%s']/../../..";
    private final static String DOCUMENT_SELECTOR_PATTERN = "//div[@class='listing-item__info']//span[contains(text(),'%s')]/../../..";
    private final MainMenu mainMenu = new MainMenu();

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public String getCommonContainPageTitle() {
        return waitForPresence(COMMON_PAGE_TITTLE_LOCATOR).getAttribute(INNER_HTML_ATTRIBUTE);
    }

    public String getPublicAccessContainPageTitle() {
        return waitForPresence(PUBLIC_ACCESS_PAGE_TITLE_LOCATOR).getAttribute(INNER_HTML_ATTRIBUTE);
    }

    public String getHistoryPageContainPageTitle() {
        return waitForPresence(HISTORY_PAGE_TITTLE_LOCATOR).getAttribute(INNER_HTML_ATTRIBUTE);
    }

    public ContainsPartObject doubleClickToOpenPack(String name) {
        doubleClickByXPathSelector(String.format(PACKAGE_SELECTOR_PATTERN, name));
        return this;
    }

    public String getPACKAGE_NAME_LOCATOR() {
        return waitForVisibility(PACKAGE_NAME_LOCATOR).getText();
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
        highlightElementAndClick(DELETE_BUTTON_LOCATOR);
        return this;
    }

    public ContainsPartObject clickButtonToCleanTrash() {
        highlightElementAndClick(TRASH_CLEAN_BUTTON_LOCATOR);
        return this;
    }

    public ContainsPartObject clickButtonToConfirmationCleanTrash() {
        highlightElementAndClick(CONFIRMATION_TRASH_CLEAN_BUTTON_LOCATOR);
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