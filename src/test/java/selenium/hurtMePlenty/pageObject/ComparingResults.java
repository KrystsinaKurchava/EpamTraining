package selenium.hurtMePlenty.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.GoogleCloudCalculatorBase;

public class ComparingResults extends GoogleCloudCalculatorBase {
    @FindBy(css = "#maia-main iframe")
    private WebElement frame;
    @FindBy(css = "md-list-item.md-1-line:nth-child(4)")
    private WebElement textVMRegularSet;
    @FindBy(css = "md-list-item.md-1-line:nth-child(6) > div:nth-child(1)")
    private WebElement textInstanceType;
    @FindBy(css = "md-list-item.md-1-line:nth-child(8) > div:nth-child(1)")
    private WebElement textRegionDate;
    @FindBy(css = "md-list-item.md-1-line:nth-child(10) > div:nth-child(1)")
    private WebElement textLocalSSD;
    @FindBy(css = "md-list-item.md-1-line:nth-child(12) > div:nth-child(1)")
    private WebElement textCommitmentTerm;

    public ComparingResults(WebDriver webDriver) {
        super(webDriver);
    }

    public String getVmRegular() {
        return textVMRegularSet.getText();
    }

    public String getTextInstanceType() {
        return textInstanceType.getText();
    }

    public String getRegion() {
        return textRegionDate.getText();
    }

    public String getLocalSSd() {
        return textLocalSSD.getText();
    }

    public String getTextCommitmentTerm() {
        return textCommitmentTerm.getText();
    }
}