package selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private static WebDriver webDriver;
    protected static final int TIME_OUT_FOR_WAIT = 30;
    private WebDriverSingleton(){}
    public static WebDriver getWebDriver(){

        if (null == webDriver){
            webDriver = new FirefoxDriver();
                       }
            webDriver.manage().window();
           webDriver.manage().timeouts().pageLoadTimeout(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);

                return webDriver;
    }

    public static void closeDriver(){
        webDriver.quit();
        webDriver = null;
    }
}
