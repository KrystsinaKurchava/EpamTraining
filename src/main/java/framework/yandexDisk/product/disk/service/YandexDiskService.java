package framework.yandexDisk.product.disk.service;

import framework.logger.Log;
import framework.yandexDisk.product.disk.screen.ContainsPartObject;
import framework.yandexDisk.product.disk.screen.CreateNewDocumentPage;
import framework.yandexDisk.product.disk.screen.MainMenu;
import framework.yandexDisk.product.disk.screen.StartYandexDiskPage;
import org.openqa.selenium.NotFoundException;
import framework.bo.User;
import framework.util.StringUtils;

public class YandexDiskService {
    public void loginYandexDisk(User user) {
        Log.info("Login in yandex disk with " + user.getUsername()
                + " username and " + user.getPassword() + " password");
        new StartYandexDiskPage()
                .clickToGoOnLoginPage()
                .inputLoginLabelClick()
                .inputLoginDate(user.getUsername())
                .clickToSignInButton()
                .waitingForUserName(user.getUsername())
                .inputPasswordLabelClick()
                .inputPasswordDate(user.getPassword())
                .clickToSignInButton();
    }

    public void loginYandexDiskWithEmptyUsername(User user) {
        Log.info("Login in yandex disk with empty username and "
                + user.getPassword() + " password");
        new StartYandexDiskPage().clickToGoOnLoginPage()
                .inputLoginLabelClick()
                .inputLoginDate(user.getUsername())
                .clickToSignInButton();
    }

    public String createNewPackage() {
        String packageName = new StringUtils().getRandomString();
        Log.info("Creating new package with  "
                + packageName + " name");
        new MainMenu()
                .сlickToGoOnPhotoPage()
                .getMainMenu()
                .сlickToGoOnFilePage()
                .getMainMenu()
                .clickCreateSMTButton()
                .clickCreateNewPackageButton()
                .inputNameOfNewPackage(packageName)
                .saveButtonClick();
        return packageName;
    }

    public String createNewDocument(String packageName, String text) {
        MainMenu mainMenu = new MainMenu();
        String documentName = new StringUtils().getRandomString();
        String mainWindowHandler = mainMenu.getCurrentWindowHandler();
        Log.info("Creating new document with  "
                + documentName + " name on " + packageName + " package");
        Log.debug("Opening package and choice to create new document");
        CreateNewDocumentPage newDocumentPage = new ContainsPartObject()
                .doubleClickToOpenPack(packageName)
                .getMainMenu()
                .clickCreateSMTButton()
                .clickCreateNewDocumentButton();
        String newDocumentPageWindowHandler = mainMenu.getOtherWindowHandler();
        Log.debug("Switch to document window, type text " + text + " and rename document." +
                " New name is " + documentName);
        mainMenu.switchToWindow(newDocumentPageWindowHandler);
        newDocumentPage
                .switchToMainIFrame()
                .clickTextInput()
                .typeText(text)
                .saveDocument()
                .clickFileMenuButton()
                .clickRenameButton()
                .enterDocumentTitle(documentName)
                .clickConfirmationDocumentTittleButton()
                .waitForTitleChanging(documentName)
                .saveDocument()
                .clickFileMenuButton()
                .clickExitButton();
        mainMenu.switchToWindow(mainWindowHandler);
        return documentName;
    }

    public String getDocumentText(String name, String packageName) {
        MainMenu mainMenu = new MainMenu();
        Log.info("Getting " + name + " document text");
        CreateNewDocumentPage createNewDocumentPage = mainMenu
                .сlickToGoOnFilePage()
                .doubleClickToOpenPack(packageName)
                .doubleClickToOpenDoc(name);
        String newDocumentPageWindowHandler = mainMenu.getOtherWindowHandler();
        mainMenu.switchToWindow(newDocumentPageWindowHandler);
        String text = createNewDocumentPage
                .switchToMainIFrame()
                .getDocumentText();
        createNewDocumentPage
                .saveDocument()
                .clickFileMenuButton()
                .clickExitButton();
        return text.trim();
    }

    public void moveElementInTheTrash(String packageName, String documentName) {
        Log.info("Moving " + documentName + " document in the trash from "
                + packageName + " package");
        MainMenu mainMenu = new MainMenu();
        mainMenu.сlickToGoOnFilePage()
                .doubleClickToOpenPack(packageName)
                .clickCreatedDoc(documentName)
                .clickDeleteDocButton();
    }

    public void cleanTrash() {
        Log.info("Clean trash");
        new MainMenu()
                .сlickToGoOnTrashPage()
                .clickButtonToCleanTrash()
                .clickButtonToConfirmationCleanTrash();
    }

    public Boolean isButtonExist() {
        MainMenu mainMenu = new MainMenu();
        Log.info("Checking that button exist");
        try {
            mainMenu.сlickToGoOnTrashPage()
                    .getMainMenu()
                    .сlickToGoOnFilePage()
                    .getMainMenu()
                    .сlickToGoOnPhotoPage()
                    .getMainMenu()
                    .сlickToGoOnLastPage()
                    .getMainMenu()
                    .сlickToGoOnGeneralAccessPage()
                    .getMainMenu()
                    .сlickToGoOnHistoryPage()
                    .getMainMenu()
                    .сlickToGoOnArchivePage()
                    .getMainMenu()
                    .сlickToGoOnLastPage();
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }
}