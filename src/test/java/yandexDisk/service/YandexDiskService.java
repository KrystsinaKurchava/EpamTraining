package yandexDisk.service;


import org.openqa.selenium.NotFoundException;
import yandexDisk.pageObject.MainMenu;
import yandexDisk.pageObject.NewDocumentCreatePageObject;
import yandexDisk.pageObject.StartYandexDiskPage;
import yandexDisk.model.User;

import java.util.Random;

public class YandexDiskService {
    private static final int MIN_STRING_LENGTH = 4;
    private static final int MAX_STRING_LENGTH = 10;
    private static final int LOGIN_WAITING = 2000;
    private static final String ALFANUMERICAL_ALL_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();

    public void loginYandexDisk(User user) {
        StartYandexDiskPage goToPage = new StartYandexDiskPage();
        goToPage.clickToGoOnLoginPage()
                .inputLoginLabelClick()
                .inputLoginDate(user.getUsername())
                .clickToSignInButton()
                .inputPasswordLabelClick()
                .inputPasswordDate(user.getPassword())
                .clickToSignInButton();
        try {
            Thread.sleep(LOGIN_WAITING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getRandomString() {
        int stringLength = random.nextInt(MAX_STRING_LENGTH);
        stringLength = stringLength < MIN_STRING_LENGTH ? MIN_STRING_LENGTH : stringLength;
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(ALFANUMERICAL_ALL_CAPS
                    .charAt(random.nextInt(ALFANUMERICAL_ALL_CAPS.length())));
        }
        return stringBuilder.toString();
    }

    public String createNewPackage() {
        MainMenu mainManu = new MainMenu();
        String packageName = getRandomString();
        mainManu.сlickToGoOnFilePage();
        mainManu.clickCreateSMTButton();
        mainManu.clickCreateNewPackageButton()
                .inputNameOfNewPackage(packageName)
                .saveButtonClick();
        return packageName;
    }

    public String createNewDocument(String packageName, String text) {
        MainMenu mainMenu = new MainMenu();
        String documentName = getRandomString();
        mainMenu.сlickToGoOnFilePage()
                .doubleClickToOpenPack(packageName);
        mainMenu.clickCreateSMTButton();
        String mainWindowHandler = mainMenu.getCurrentWindowHandler();
        NewDocumentCreatePageObject newDocumentPage = mainMenu.clickCreateNewDocumentButton();
        String newDocumentPageWindowHandler = mainMenu.getOtherWindowHandler();
        mainMenu.switchToWindow(newDocumentPageWindowHandler);
        newDocumentPage
                .switchToMainIFrame()
                .clickTextInput()
                .typeText(text)
                .saveDocument()
                .clickFileMenuButton()
                .clickCloseFileMenuButton()
                .clickFileMenuButton()
                .clickRenameButton()
                .enterDocumentTitle(documentName)
                .saveDocument()
                .clickFileMenuButton()
                .clickExitButton();
        mainMenu.switchToWindow(mainWindowHandler);
        return documentName;
    }

    public String getDocumentText(String name, String packageName) {
        MainMenu mainMenu = new MainMenu();
        NewDocumentCreatePageObject newDocumentCreatePageObject = mainMenu
                .сlickToGoOnFilePage()
                .doubleClickToOpenPack(packageName)
                .doubleClickToOpenDoc(name);
        String newDocumentPageWindowHandler = mainMenu.getOtherWindowHandler();
        mainMenu.switchToWindow(newDocumentPageWindowHandler);
        String text = newDocumentCreatePageObject
                .switchToMainIFrame()
                .getText();
        newDocumentCreatePageObject
                .saveDocument()
                .clickFileMenuButton()
                .clickCloseButton();
        return text.trim();
    }

    public void moveElementInTheTrash(String packageName, String documentName) {
        MainMenu mainMenu = new MainMenu();
        mainMenu
                .сlickToGoOnFilePage()
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
        MainMenu mainManu = new MainMenu();
        try {
            mainManu.сlickToGoOnFilePage();
            mainManu.сlickToGoOnTrashPage();
            mainManu.сlickToGoOnFotoPage();
            mainManu.сlickToGoOnGeneralAccessPage();
            mainManu.сlickToGoOnHistoryPage();
            mainManu.сlickToGoOnArchivePage();
            mainManu.сlickToGoOnLastPage();
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }
}