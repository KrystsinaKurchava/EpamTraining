package bdd.yandex.product.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.bo.UserFactory;
import framework.yandexDisk.product.disk.screen.ContainsPartObject;
import framework.yandexDisk.product.disk.screen.MainMenu;
import framework.yandexDisk.product.disk.service.YandexDiskService;
import org.testng.Assert;

public class ClickButtonAndCompareTittleStepDefs {
    private String tittleOnPage;

    @And("^[U|u]ser logged in successfully$")
    public void userLoggedInSuccessfully() {
        new YandexDiskService().loginYandexDisk(UserFactory.withCredentialsFromProperty());
    }

    @When("^[U|u]ser clicks (.*) menu's button which has (.*) name$")
    public void userClicksButton(String name, String system) {
        new MainMenu().сlickButtonPattern(system);
        switch (name.toLowerCase()) {
            case "history":
                tittleOnPage = new ContainsPartObject().getHistoryPageContainPageTitle();
                break;
            case "newest":
            case "public access":
            case "photo":
                tittleOnPage = new ContainsPartObject().getPublicAccessContainPageTitle();
                break;
            default:
                tittleOnPage = new ContainsPartObject().getCommonContainPageTitle();
        }
    }

    @Then("^got title and (.*) title is equal$")
    public void expectedAngGotTitleIsEqual(String expected) {
        Assert.assertEquals(tittleOnPage, expected, "Title page and button is different");
    }
}