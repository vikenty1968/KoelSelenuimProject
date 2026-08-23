package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReportManager;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestListener implements ITestListener {
    ExtentReportManager reportManager =new ExtentReportManager();

    @Override
    public void onTestFailure(ITestResult result) {
        reportManager.testFailed(result.getThrowable());
        System.out.println("Test failed"+ result.getName());
        if(result.getThrowable()!=null) {
            System.out.println("Result is  " + result.getThrowable());
        }
        // TakingScreenShot

            Object obj = result.getInstance();
            BaseTest test =(BaseTest)obj;
            TakesScreenshot ts = (TakesScreenshot)test.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);

            Path destination = Paths.get(
                    "screenshots",
                    result.getName() + ".png"
            );

            try {
                Files.createDirectories(destination.getParent());
                Files.copy(
                        source.toPath(),
                        destination,
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException("Test failed with error :"+ e.getMessage());
            }

        }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started " + result.getName());
        reportManager.createTest(result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test success "+ result.getName());
        reportManager.testPassed();
    }
    @Override
    public void onFinish(ITestContext context){
        reportManager.flushReport();
    }
    }


