package framework.listener;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import framework.util.WebDriverSingleton;

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
        WebDriverSingleton.saveScreenshot();
        log.info(iTestResult.getName() + " was success");
    }

    public void onTestFailure(ITestResult iTestResult) {
        WebDriverSingleton.saveScreenshot();
        log.error(iTestResult.getName() + " failed");

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

}