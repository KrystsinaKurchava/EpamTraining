package selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
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
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                }
                case "chrome" :{
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
                }
                default: {
                    DesiredCapabilities capabilities = new   DesiredCapabilities();
                    capabilities.setPlatform(Platform.WINDOWS);
                    capabilities.setBrowserName("firefox");
                    try {
                        webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                                capabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
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
