package selenium.hurtMePlenty.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.GoogleCloudCalculatorBase;

public class ComparingResults extends GoogleCloudCalculatorBase {
    @FindBy(css = "#maia-main iframe")
    private WebElement frame;
    @FindBy(css = "md-list-item.md-1-line:nth-child(4)")
    private WebElement vmRegularset;
    @FindBy(css = "md-list-item.md-1-line:nth-child(6) > div:nth-child(1)")
    private WebElement instanceType;
    @FindBy(css = "md-list-item.md-1-line:nth-child(8) > div:nth-child(1)")
    private WebElement regionDate;
    @FindBy(css = "md-list-item.md-1-line:nth-child(10) > div:nth-child(1)")
    private WebElement localSSD;
    @FindBy(css = "md-list-item.md-1-line:nth-child(12) > div:nth-child(1)")
    private WebElement commitmentTerm;

    public ComparingResults(WebDriver webDriver) {
        super(webDriver);
    }

    public String findVmRegular() {
        return vmRegularset.getText();
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
}