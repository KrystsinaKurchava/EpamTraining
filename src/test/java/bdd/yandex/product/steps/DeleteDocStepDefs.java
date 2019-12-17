package bdd.yandex.product.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.yandexDisk.product.disk.screen.ContainsPartObject;
import framework.yandexDisk.product.disk.screen.MainMenu;
import framework.yandexDisk.product.disk.service.YandexDiskService;
import org.testng.Assert;

public class DeleteDocStepDefs {
    private YandexDiskService yandexDiskService = new YandexDiskService();
    private ContainsPartObject containsPartObject = new ContainsPartObject();
    private MainMenu mainMenu = new MainMenu();

    @Given("^[U|u]ser deleted document with name (.*) from package (.*)$")
    public void userDeletedDocumentFromPackage(String documentName, String packageName) {
        yandexDiskService.moveElementInTheTrash(packageName, documentName);
    }

    @Then("^[D|d]ocument (.*) does not exist in package (.*)$")
    public void documentThatDocumentDoesNotExistInPackage(String documentName, String packageName) {
        mainMenu.сlickToGoOnFilePage();
        containsPartObject.doubleClickToOpenPack(packageName);
        Assert.assertFalse(containsPartObject.checkThatDocumentExist(documentName),
                "Document didn't delete");
    }

    @And("^[D|d]ocument (.*) is in trash$")
    public void documentTestDocumentIsInTrash(String documentName) {
        Assert.assertTrue(mainMenu.сlickToGoOnTrashPage().checkThatDocumentExist(documentName),
                "Document isn't in trash");
    }

    @Given("^[U|u]ser cleaned trash$")
    public void userCleanedTrash() {
        yandexDiskService.cleanTrash();
    }

    @Then("^[T|t]rash doesn't contain document (.*)$")
    public void trashEmpty(String documentName) {
        Assert.assertFalse(new ContainsPartObject().checkThatDocumentExist(documentName),
                "Trash not empty");
    }
}