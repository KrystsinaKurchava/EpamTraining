package yandexDick.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import selenium.base.PageObjectBase;

public class ContainsPartObject extends PageObjectBase {
   // private final By pageLastTitle = By.cssSelector(".listing-heading__title");
//    private final By pagePhotoTitle = By.cssSelector(".listing-heading__title");
    //должно быть Публичные ссылки, а не просто общий доступ
    private final By pagePublicAccessTitle = By.cssSelector("a[href='/client/published']");
    private final By pageHistoryTitle = By.cssSelector(".journal-filter__header");
   //    private final By pageArchiveTitle = By.cssSelector(".listing-heading__title");
//    private final By pageTrashTitle = By.cssSelector(".listing-heading__title");

    private final By pageTitleCommon = By.cssSelector(".listing-heading__title");
    private final By createdPackageORDocument = By.cssSelector("div.listing-item:nth-child(1)");

    public String getCommonTitleContainPage() {
        return findClickableElement(pageTitleCommon).getText();
    }
    public String getPublicAccessTitleContainPage() {
        return findClickableElement(pagePublicAccessTitle).getText();
    }
    public String getHistoryPageTitleContainPage() {
        return findClickableElement(pageHistoryTitle).getText();
    }

    //CHECK
    public ContainsPartObject findCreatedPAckageOrDoc(){
        findClickableElement(createdPackageORDocument);
        return new ContainsPartObject();
    }

    public ContainsPartObject doubleClickToOpenPack(String name){
        Actions builder = new Actions(webDriver);
        By nameOfPack = By.cssSelector("//span[text()='"+name+"']/../../..");
        builder.doubleClick(findClickableElement(nameOfPack));
        return new ContainsPartObject();
    }
    public NewDocumentCreatePO doubleClickToOpenDoc(){
        Actions builder = new Actions(webDriver);
        builder.doubleClick(findClickableElement(createdPackageORDocument));
        return new NewDocumentCreatePO();
    }

}
