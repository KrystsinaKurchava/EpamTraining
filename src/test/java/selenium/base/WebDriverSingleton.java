package selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver webDriver;
    protected static final int TIME_OUT_FOR_WAIT = 30;
static {
    BasicConfigurator.configure();
}
    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            //System.getProperty("browser")
            switch ("chrome") {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                }
            }
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().setScriptTimeout(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
            webDriver.manage().timeouts().pageLoadTimeout(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
            webDriver.manage().timeouts().implicitlyWait(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
        }

        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
