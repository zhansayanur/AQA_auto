package lesson_14.utils;

import io.qameta.allure.Attachment;
import lesson_14.DriverSetup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyAllureListeners implements ITestListener {
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenShot(byte[] screenShot){
        return screenShot;
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test with name " + result.getMethod().getMethodName() + " started!!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenShot(((TakesScreenshot) DriverSetup.startDriver()).getScreenshotAs(OutputType.BYTES));
    }

}
