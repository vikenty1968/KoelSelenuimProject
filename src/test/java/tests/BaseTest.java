package tests;

import config.ConfigReader;
import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class BaseTest {
  //  protected WebDriver driver;
    DriverFactory driverFactory;
    ConfigReader configReader;
    @BeforeClass(alwaysRun = true)
            public void readConfigFile() {
      configReader = new ConfigReader();
      driverFactory = new DriverFactory();
    }
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser) throws MalformedURLException {
        //if remote driver was not install use local
        if(browser==null){
            browser=configReader.getProperty("browser");
        }
      WebDriver  driver=driverFactory.setUpDriver(browser,configReader.getProperty("execution"));
        DriverManager.setDriver(driver);
        getDriver().get(configReader.getProperty("baseURL"));
    //    getDriver().manage().window().maximize();

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(DriverManager.getDriver()!=null){
            DriverManager.getDriver().quit();
            DriverManager.removeDriver();
        }

    }
    public WebDriver getDriver(){
        return DriverManager.getDriver();
    }
}
