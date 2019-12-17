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
    private final String LOGIN_YANDEX_DISK_LOG_TEXT = "Login in yandex disk with %s" +
            " username and %s password";
    private final String LOGIN_YANDEX_DISK_WITH_EMPTY_USERNAME_LOG_TEXT = "Login in yandex disk with empty username and %s" +
            " password";
    private final String CREATE_NEW_PACKAGE_LOG_TEXT = "Creating new package with %s" +
            "name";
    private final String CREATE_NEW_DOCUMENT_LOG_TEXT = "Creating new document with  " +
            "%s name on %s package";
    private final String GET_DOCUMENT_TEXT_LOG_TEXT = "Getting %s document text";
    private final String MOVE_ELEMENT_IN_THE_TRASH = "Moving %s document in the trash from " +
            "%s package";

    public void loginYandexDisk(User user) {
        Log.info(LOGIN_YANDEX_DISK_LOG_TEXT, user.getUsername(), user.getPassword());
        new StartYandexDiskPage()
                .clickToGoOnLoginPage()
                .clickLoginLabelInput()
                .inputLoginDate(user.getUsername())
                .clickToSignInButton()
                .waitingForUserName(user.getUsername())
                .clickPasswordLabelInput()
                .inputPasswordDate(user.getPassword())
                .clickToSignInButton();
    }

    public void loginYandexDiskWithEmptyUsername(User user) {
        Log.info(LOGIN_YANDEX_DISK_WITH_EMPTY_USERNAME_LOG_TEXT, user.getPassword());
        new StartYandexDiskPage().clickToGoOnLoginPage()
                .clickLoginLabelInput()
                .inputLoginDate(user.getUsername())
                .clickToSignInButton();
    }

    public String createNewPackage(String packageName) {
        Log.info(CREATE_NEW_PACKAGE_LOG_TEXT, packageName);
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

    public String createNewDocument(String packageName, String documentName, String text) {
        MainMenu mainMenu = new MainMenu();
        String mainWindowHandler = mainMenu.getCurrentWindowHandler();
        Log.info(CREATE_NEW_DOCUMENT_LOG_TEXT, documentName, packageName);
        Log.debug("Opening package and choice to create new document");
        CreateNewDocumentPage newDocumentPage = new ContainsPartObject()
                .doubleClickToOpenPack(packageName)
                .getMainMenu()
                .clickCreateSMTButton()
                .clickCreateNewDocumentButton();
        String newDocumentPageWindowHandler = mainMenu.getOtherWindowHandler();
        Log.debug("Switch to document window, type text and rename document.");
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
        Log.info(GET_DOCUMENT_TEXT_LOG_TEXT, name);
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
        Log.info(MOVE_ELEMENT_IN_THE_TRASH, documentName, packageName);
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