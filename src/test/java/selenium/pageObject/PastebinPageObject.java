package selenium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinPageObject {
    private WebDriver webDriver;
    @FindBy(css = "#paste_code")
    private WebElement inputTextInNewPaste;
    @FindBy(xpath = "//*[@class='select2-selection__rendered' and @title='Never']/..")
    private WebElement selectPasteExpiration;
    @FindBy(xpath = "//*[@name='paste_name']")
    private WebElement inputPasteName;
    @FindBy(xpath = "//*[@id='submit']")
    private WebElement buttonForCreateNewPaste;

    private final By tenMinutesListElement = By.xpath("//li[text()='10 Minutes']");
    private final String newPasteText = "Hello from WebDriver";
    private final String pasteNameText = "helloweb";

    public PastebinPageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void createNewPaste() {
        inputTextInNewPaste.sendKeys(newPasteText);
        selectPasteExpiration.click();
        getElement(tenMinutesListElement).click();
        inputPasteName.sendKeys(pasteNameText);
        buttonForCreateNewPaste.click();
    }

    private WebElement getElement(By by) {
        return webDriver.findElement(by);
    }
}