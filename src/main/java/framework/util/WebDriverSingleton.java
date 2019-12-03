package framework.util;

import framework.logger.Log;
import framework.runner.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    protected static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    protected static final int TIME_OUT_FOR_WAIT = 30;

    static {
        BasicConfigurator.configure();
    }

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (webDriver.get() == null) {
            switch (Parameters.instance().getBrowserType()) {
                case BrowserType.FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver.set(new FirefoxDriver());
                    break;
                }
                case BrowserType.EDGE: {
                    WebDriverManager.edgedriver().setup();
                    webDriver.set(new EdgeDriver());
                    break;
                }
                case BrowserType.CHROME: {
                    WebDriverManager.chromedriver().setup();
                    webDriver.set(new ChromeDriver());
                    break;
                }
                default: {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setPlatform(Platform.WINDOWS);
                    capabilities.setBrowserName(BrowserType.CHROME);
                    try {
                        webDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                                capabilities));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }
            manageDriver();
        }
        return webDriver.get();
    }

    public static void closeDriver() {
        webDriver.get().quit();
        webDriver.set(null);
    }

    private static void manageDriver() {
        webDriver.get().manage().window().maximize();
        webDriver.get().manage().timeouts().setScriptTimeout(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
        webDriver.get().manage().timeouts().pageLoadTimeout(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
        webDriver.get().manage().timeouts().implicitlyWait(TIME_OUT_FOR_WAIT, TimeUnit.SECONDS);
    }

    public static void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) webDriver.get())
                .getScreenshotAs(OutputType.FILE);
        try {
            File screenShot = new File(
                    Parameters.instance().getOutputAddress() +
                            "/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png");
            FileUtils.copyFile(screenCapture, screenShot);
            Log.info("Screenshot taken: file:<a href=\"file:///" + screenShot.getAbsolutePath() + "\" 'target=\"blank\">screenshot.file</a>");
        } catch (IOException e) {
            Log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}