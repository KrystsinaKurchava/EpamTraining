package yandexDick;

import org.testng.Assert;
import org.testng.annotations.Test;
import yandexDick.pageObject.MainMenu;
import yandexDick.pageObject.StartYandexDiskPage;
import yandexDick.pageObject.User;
import yandexDick.pageObject.UserCreator;

public class test {
    private final String LINK_FOR_PASTERBIN = "https://disk.yandex.by/";
    private final String NEW_DOCUMENT_TEXT = "Hello world";
      private final int LENGHT_OF_PACKAGE_NAME = 3;

    @Test(description = "")
    public void loginPositive() {
        StartYandexDiskPage ada = new StartYandexDiskPage();
        ada.goToPage(LINK_FOR_PASTERBIN);

        User testUser = UserCreator.withCredentialsFromProperty();
        loginYandexDisk(testUser);

        MainMenu mainManu = new MainMenu();


      Assert.assertEquals( mainManu.сlickToGoOnLastPage()
                .getCommonTitleContainPage(),"Last");
        Assert.assertEquals( mainManu.сlickToGoOnFilePage()
                .getCommonTitleContainPage(),"File");

}
