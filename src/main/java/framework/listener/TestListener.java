package framework.listener;

import framework.util.WebDriverSingleton;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private Logger log = LogManager.getRootLogger();

    public void onTestStart(ITestResult iTestResult) {
        log.debug(iTestResult.getName() + " start");
    }

    public void onTestSuccess(ITestResult iTestResult) {
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