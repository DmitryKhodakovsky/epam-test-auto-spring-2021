package ru.training.at.lesson4.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.training.at.lesson4.utils.AttachmentUtils;

import java.util.Arrays;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("EEE: onTestFailure.enter " + result.getName());
        Object driver = result.getTestContext().getAttribute("driver");

        if (driver != null) {
            AttachmentUtils.makeStringAttachment(Arrays.asList(
                    "test context contains driver:",
                    driver.toString()
            ));
            // in the same way WebDriver can be cast to Screenshot taker
            // ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        System.out.println("EEE: onTestFailure.exit");
    }
}
