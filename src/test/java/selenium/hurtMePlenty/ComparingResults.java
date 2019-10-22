package selenium.hurtMePlenty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.PageObjectBase;

public class ComparingResults extends PageObjectBase {

    @FindBy(css = "#maia-main iframe")
    private WebElement frame;
    @FindBy(css = "md-list-item.md-1-line:nth-child(4)")
    private WebElement vmRegular;
    @FindBy(css = "md-list-item.md-1-line:nth-child(6) > div:nth-child(1)")
    private WebElement instanceType;
    @FindBy(css = "md-list-item.md-1-line:nth-child(8) > div:nth-child(1)")
    private WebElement regionDate;
    @FindBy(css = "md-list-item.md-1-line:nth-child(10) > div:nth-child(1)")
    private WebElement localSSD;
    @FindBy(css = "md-list-item.md-1-line:nth-child(12) > div:nth-child(1)")
    private WebElement commitmentTerm;
    @FindBy(css = "h2.md-title:nth-child(2) > b:nth-child(1)")
    private WebElement resultOfCointing;

    public String findVmRegular() {
        return vmRegular.getText();
    }

    public String getInstanceType() {
        return instanceType.getText();
    }

    public String getRegion() {
        return regionDate.getText();
    }

    public String getLocalSSd() {
        return localSSD.getText();
    }

    public String getCommitmentTerm() {
        return commitmentTerm.getText();
    }

    public String getResultOfCointing() {
        return resultOfCointing.getText();
    }

    public ComparingResults(WebDriver webDriver) {
        super(webDriver);
    }
}