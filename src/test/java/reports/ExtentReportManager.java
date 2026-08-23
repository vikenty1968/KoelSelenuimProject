package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
  private ExtentSparkReporter sparkReporter;
  private ExtentReports extentReports;
  private ExtentTest extentTest;
  public ExtentReportManager(){
    sparkReporter=new ExtentSparkReporter("reports/ExtentReport.html");
    extentReports = new ExtentReports();
    extentReports.attachReporter(sparkReporter);
  }
  public void createTest(String testName) {
    extentTest = extentReports.createTest(testName);
  }
  public void testPassed() {
    extentTest.pass("Test passed");
  }

  public void testFailed(Throwable throwable) {
    extentTest.fail(throwable);
  }

  public void flushReport() {
    extentReports.flush();
  }
}
