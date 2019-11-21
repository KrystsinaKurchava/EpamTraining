package yandexDisk.service;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import selenium.base.WebDriverSingleton;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger log = LogManager.getRootLogger();

    public void onTestStart(ITestResult iTestResult) {
        log.debug(iTestResult.getName() + " start");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info(iTestResult.getName() + " was success");
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.warn(iTestResult.getName() + " failed");
        saveScreenshot();
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.warn(iTestResult.getName() + " skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.warn(iTestResult.getName() + " failed");
    }

    public void onStart(ITestContext iTestContext) {
        log.debug(iTestContext.getName() + "  start");
    }

    public void onFinish(ITestContext iTestContext) {
        log.debug(iTestContext.getName() + "  finish");
    }

    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) WebDriverSingleton
                .getWebDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}