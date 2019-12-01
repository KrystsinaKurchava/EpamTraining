package framework.listener;

import framework.logger.Log;
import framework.util.WebDriverSingleton;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        Log.debug(iTestResult.getName() + " start");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(iTestResult.getName() + " was success");
    }

    public void onTestFailure(ITestResult iTestResult) {
        WebDriverSingleton.saveScreenshot();
        Log.error(iTestResult.getName() + " failed");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        Log.warn(iTestResult.getName() + " skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.warn(iTestResult.getName() + " failed");
    }

    public void onStart(ITestContext iTestContext) {
        Log.debug(iTestContext.getName() + "  start");
    }

    public void onFinish(ITestContext iTestContext) {
        Log.debug(iTestContext.getName() + "  finish");
    }
}