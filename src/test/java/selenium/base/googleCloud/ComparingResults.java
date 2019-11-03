package selenium.base.googleCloud;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparingResults extends GoogleCloudCalculatorPage {
    @FindBy(id = "maia-main iframe")
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