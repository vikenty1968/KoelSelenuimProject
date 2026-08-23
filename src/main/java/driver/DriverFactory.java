package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public WebDriver setUpDriver(String browser, String execution) throws MalformedURLException {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                //       options.addArguments("--start-maximized");
                options.addArguments("--lang=en-US");
                if (execution.equalsIgnoreCase("local")) {
                    return new ChromeDriver(options);
                }
                if (execution.equalsIgnoreCase("remote")) {

                    URL gridUrl = new URL("http://localhost:4444");
                    RemoteWebDriver remoteDriver =
                            new RemoteWebDriver(gridUrl, options);
                    System.out.println("Session ID " + remoteDriver.getSessionId());
               //     System.out.println("Capabilities : " + remoteDriver.getCapabilities());

                    return remoteDriver;
                }

                throw new IllegalArgumentException("Unsupported execution" + execution);

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference(
                        "intl.accept_languages", "en-US"
                );
                firefoxOptions.addPreference(
                        "permissions.default.desktop-notification", 2);

                return new FirefoxDriver(firefoxOptions);

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--lang=en-US");
                edgeOptions.addArguments("--disable-notifications");
                return new EdgeDriver(edgeOptions);

            case "safari":
                return new SafariDriver();

            default:
                throw new IllegalArgumentException("Unsupported browser" + browser);

        }
    }


}
