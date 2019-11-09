package yandexDick.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class Service {
    private static final int maxStringLength = 10;
    private static final String ALFANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();
    WebDriver webDriver;

    public void loginYandexDisk(User user) {
        StartYandexDiskPage goToPage = new StartYandexDiskPage();
        goToPage.clickToGoOnLoginPage()
                .inputLoginLabelClick()
                .inputLoginDate(user.getUsername())
                .clickToConfirmationLoginButton()
                .inputPasswordLabelClick()
                .inputPasswordDate(user.getPassword())
                .clickToConfirmationPasswordButton();
    }

    public static String getRandomString(int stringLength) {
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(ALFANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALFANUMERICAL_ALL_CAPS.length())));
        }
        return stringBuilder.toString();
    }

    public String createNewPackage() {
        MainMenu mainManu = new MainMenu();
        String packageName = getRandomString(random.nextInt(maxStringLength));
        mainManu.сlickToGoOnFilePage();
        mainManu.clickCreateSMTButton();
        mainManu
                .clickCreateNewPackageButton()
                .inputNameOfNewPackage(packageName)
                .saveButtonClick();
        return packageName;
    }

    public String createNewDocument(String packageName, String text) {
        MainMenu mainMenu = new MainMenu();
        String documentName = getRandomString(random.nextInt(maxStringLength));
        mainMenu.сlickToGoOnFilePage()
                .doubleClickToOpenPack(packageName);
        mainMenu.clickCreateSMTButton();
        mainMenu.clickCreateNewDocumentButton()
                .clickDocumentTitle()
                .enterDocumentTitle(documentName)
                .typeText(text)
                .saveDocument()
                .returnToYandexPage();
        return documentName;
    }

    public String getDocumentText(String name, String packageName) {

        return new MainMenu().сlickToGoOnFilePage()
                .doubleClickToOpenPack(packageName)
                .doubleClickToOpenDoc(name)
                .getText();
    }

    public void moveElementInTheTrash(String packageName, String documentName) {
        Actions builder = new Actions(webDriver);
        ContainsPartObject contain = new ContainsPartObject();
        MainMenu mainMenu = new MainMenu();
        mainMenu
                .сlickToGoOnFilePage()
                .doubleClickToOpenPack(packageName);
        WebElement trash = mainMenu.getTrashAddress();
        Action dragAndDrop = builder
                .clickAndHold(contain.findCreatedDoc(documentName))
                .moveToElement(trash)
                .release(trash)
                .build();
        dragAndDrop.perform();
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
