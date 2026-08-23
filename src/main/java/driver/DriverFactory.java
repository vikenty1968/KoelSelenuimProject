package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public WebDriver setUpDriver(String browser) {
        switch (browser.toLowerCase()){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
         //       options.addArguments("--start-maximized");
                options.addArguments("--lang=en-US");
                return new ChromeDriver(options);
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference(
                        "intl.accept_languages", "en-US"
                );
                firefoxOptions.addPreference(
                        "permissions.default.desktop-notification",2);

                return new FirefoxDriver(firefoxOptions);

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--lang=en-US");
                edgeOptions.addArguments("--disable-notifications");
                return new EdgeDriver(edgeOptions);

            case "safari":
                return new SafariDriver();

            default:
               throw new IllegalArgumentException("Unsupported browser"+ browser);

        }
    }


}
