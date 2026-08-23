package tests;

import config.ConfigReader;
import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
      WebDriver  driver=driverFactory.setUpDriver(configReader.getProperty("browser"));
        DriverManager.setDriver(driver);
        getDriver().get(configReader.getProperty("baseURL"));
        getDriver().manage().window().maximize();

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
