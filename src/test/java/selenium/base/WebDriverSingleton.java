package selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
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
            switch (System.getProperty("browser")) {
                case BrowserType.FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                }
                case BrowserType.EDGE: {
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                }
                case BrowserType.CHROME: {
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
                }
                default: {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setPlatform(Platform.WINDOWS);
                    capabilities.setBrowserName(BrowserType.CHROME);
                    try {
                        webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                                capabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }
            manageDriver();
        }
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }

    private static void manageDriver() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().setScriptTimeout(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
    }
}