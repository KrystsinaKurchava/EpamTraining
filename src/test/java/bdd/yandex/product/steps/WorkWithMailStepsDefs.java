package bdd.yandex.product.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.bo.UserFactory;
import framework.yandexDisk.product.disk.screen.ContainsPartObject;
import framework.yandexDisk.product.disk.screen.MainMenu;
import framework.yandexDisk.product.disk.service.YandexDiskService;
import org.testng.Assert;

public class WorkWithMailStepsDefs {
    private String tittleOnPage;

    @And("^user logged in successfully$")
    public void userLoggedInSuccessfully() {
        new YandexDiskService().loginYandexDisk(UserFactory.withCredentialsFromProperty());
    }

    @When("^user wants to click (.*) button which has (.*) name$")
    public void userClicksButton(String name, String system) {
        new MainMenu().сlickButtonPattern(system);
        switch (name.toLowerCase()) {
            case "history":
                tittleOnPage = new ContainsPartObject().getHistoryPageContainPageTitle();
                break;
            case "public access":
                tittleOnPage = new ContainsPartObject().getPublicAccessContainPageTitle();
                break;
            default:
                tittleOnPage = new ContainsPartObject().getCommonContainPageTitle();
                break;
        }
    }

    @Then("^(.*) title ang getted title is equal$")
    public void expectedAngGettedTitleIsEqual(String expected) {
        Assert.assertEquals(tittleOnPage, expected, "Title page and button is different");
    }
}