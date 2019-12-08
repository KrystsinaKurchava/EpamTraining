package bdd.yandex.product.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.bo.User;
import framework.bo.UserFactory;
import framework.logger.Log;
import framework.util.WebDriverSingleton;
import framework.yandexDisk.product.disk.screen.StartYandexDiskPage;
import org.testng.Assert;

public class LoginStepDefs {
    private StartYandexDiskPage startYandexDiskPage = new StartYandexDiskPage();
    protected final String LINK_FOR_YANDEX_DISK = "https://disk.yandex.by/";
    private User user;

    @Given("^user is on login page$")
    public void userIsOnLoginPage() {
     WebDriverSingleton.getWebDriver().get(LINK_FOR_YANDEX_DISK);
    }

    @Given("^user has valid credentials$")
    public void userHasValidCredentials() {
        user = new UserFactory().withCredentialsFromProperty();
    }

    @When("^user clicks login button$")
    public void userClicksLoginButton() {
        startYandexDiskPage.clickToGoOnLoginPage();
    }

    @And("^user enters login$")
    public void usersEntersLogin() {
        startYandexDiskPage.clickLoginLabelInput().inputLoginDate(user.getUsername()).clickToSignInButton();
    }

    @And("^user enters password$")
    public void userEntersPassword() {
        startYandexDiskPage.clickPasswordLabelInput().inputPasswordDate(user.getPassword()).clickToSignInButton();
    }

    @And("^user clicks sign in button$")
    public void userClicksSignInButton() {
        startYandexDiskPage.clickToSignInButton();
    }

    @Given("^user has invalid login$")
    public void userHasInvalidLogin() {
        user = new UserFactory().withEmptyUsername();
    }

    @Then("^user is on Personal page$")
    public void userIsOnFilePage() {
        Assert.assertTrue(startYandexDiskPage.isPersonalCabinetExist(), "Login hasn't done");
    }

    @Given("^user has invalid password$")
    public void userHasInvalidPassword() {
        user = new UserFactory().withEmptyPassword();
    }

    @And("^user enters (.*) login$")
    public void usersEntersLoginLogin(String login) {
        startYandexDiskPage.clickLoginLabelInput().inputLoginDate(login).clickToSignInButton();
    }

    @And("^user enters  (.*) password$")
    public void userEntersPasswordPassword(String password) {
        startYandexDiskPage.clickLoginLabelInput().inputPasswordDate(password);
    }

    @Then("^user has error (.*)$")
    public void userHasErrorMessage(String message) {
        Assert.assertEquals(new StartYandexDiskPage().getErrorMessage(), message, "Error message is invalid");
    }

    @After
    public void tearDown(){
        Log.info("Close browser");
        WebDriverSingleton.closeDriver();
    }
}