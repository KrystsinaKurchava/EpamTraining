package selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PasterbinBase {
    private WebDriver webDriver;
    @FindBy(css = "#paste_code")
    protected WebElement inputTextInNewPaste;
    @FindBy(xpath = "//*[@class='select2-selection__rendered' and @title='Never']/..")
    protected WebElement selectPasteExpiration;
    @FindBy(xpath = "//*[@name='paste_name']")
    protected WebElement inputPasteName;
    @FindBy(xpath = "//*[@id='submit']")
    protected WebElement buttonForCreateNewPaste;

    public PasterbinBase(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    public abstract void createNewPaste();
}