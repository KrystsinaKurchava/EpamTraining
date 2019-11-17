package yandexDisk.service;

import org.openqa.selenium.NotFoundException;
import yandexDisk.pageObject.ContainsPartObject;
import yandexDisk.pageObject.MainMenu;
import yandexDisk.pageObject.CreateNewDocumentPage;
import yandexDisk.pageObject.StartYandexDiskPage;
import yandexDisk.model.User;
import yandexDisk.util.StringUtils;

public class YandexDiskService {
    public void loginYandexDisk(User user) {
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
        new StartYandexDiskPage().clickToGoOnLoginPage()
                .inputLoginLabelClick()
                .inputLoginDate(user.getUsername())
                .clickToSignInButton();
    }

    public String createNewPackage() {
        String packageName = new StringUtils().getRandomString();
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
        CreateNewDocumentPage newDocumentPage = new ContainsPartObject()
                .doubleClickToOpenPack(packageName)
                .getMainMenu()
                .clickCreateSMTButton()
                .clickCreateNewDocumentButton();
        String newDocumentPageWindowHandler = mainMenu.getOtherWindowHandler();
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
        MainMenu mainMenu = new MainMenu();
        mainMenu.сlickToGoOnFilePage()
                .doubleClickToOpenPack(packageName)
                .clickCreatedDoc(documentName)
                .clickDeleteDocButton();
    }

    public void cleanTrash() {
        new MainMenu()
                .сlickToGoOnTrashPage()
                .clickButtonToCleanTrash()
                .clickButtonToConfirmationCleanTrash();
    }

    public Boolean checkButtonsExist() {
        MainMenu mainMenu = new MainMenu();
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