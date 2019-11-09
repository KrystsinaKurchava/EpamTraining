package yandexDick.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class Service {
    private static final String ALFANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();
WebDriver webDriver;

    public void loginYandexDisk(User user) {
        StartYandexDiskPage goToPage = new StartYandexDiskPage();
        goToPage.clickToGoOnLoginPage()
                .inputLoginClick()
                .inputLoginDate(user.getUsername())
                .clickToConfirmationLoginButton()
                .inputPasswordClick()
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


    public String createNewPackage(int lenght) {
        MainMenu mainManu = new MainMenu();
       String sfsdd= getRandomString(lenght);
        mainManu.сlickToGoOnFilePage();
        mainManu.clickCreateSMTButton();
        mainManu.clickCreateNewPackageButton()
                .inputNameOfNewPackage(sfsdd)
                .saveButtonClick();
   return  sfsdd;
    }

    public void createNewDocument(String text, String packageName) {
        MainMenu mainManu = new MainMenu();
        mainManu.сlickToGoOnFilePage()
                .doubleClickToOpenPack(packageName);
        mainManu.clickCreateSMTButton();
        mainManu.clickCreateNewDocumentButton()
                .typeText(text)
                .returnToYandexPage();
    }


    public ContainsPartObject moveElementInTheTrash(By element) {
        Actions builder = new Actions(webDriver);
        getTrashAddress
        Action dragAndDrop = builder
                .clickAndHold(findClickableElement(element))
                .moveToElement(findClickableElement(element))
                .release(otherElement)
                .build();

        dragAndDrop.perform();
    }
}
