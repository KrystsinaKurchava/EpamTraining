package bdd.yandex.product.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.yandexDisk.product.disk.screen.ContainsPartObject;
import framework.yandexDisk.product.disk.service.YandexDiskService;
import org.testng.Assert;

public class CreateNewDocAndPackageStepDefs {
    private YandexDiskService yandexDiskService = new YandexDiskService();
    private ContainsPartObject containsPartObject = new ContainsPartObject();

    @Given("^[U|u]ser created new package with name (.*)$")
    public void userCreatedNewPackageWithNameTestPackage(String name) {
        yandexDiskService.createNewPackage(name);
    }

    @When("^[U|u]ser open the package (.*)$")
    public void userOpenThePackageTestPackage(String name) {
        containsPartObject.doubleClickToOpenPack(name);
    }

    @Then("^[C|c]reated package name is (.*)$")
    public void createdPackageNameIsTestPackage(String name) {
        Assert.assertEquals(containsPartObject.getPackageName(), name,
                "Package was not created or inaccessible");
    }

    @Given("^[U|u]ser created new document with name (.*) with text (.*) in package (.*)$")
    public void userCreatedNewDocumentWithText(String documentName, String text, String packageName) {
        yandexDiskService.createNewDocument(packageName, documentName, text);
    }

    @Then("^[D|d]ocument (.*) in package (.*) has text (.*)$")
    public void documentTestDocumentHasText(String documentName, String packageName, String text) {
        Assert.assertEquals(yandexDiskService.getDocumentText(documentName, packageName),
                text, "Document saved incorrect");
    }
}