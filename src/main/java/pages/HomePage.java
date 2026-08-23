package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private By logOutBtn = By.cssSelector("[data-testid='btn-logout']");
    public boolean isLogOutBtnDisplayed(){
        return isElementDisplayed(logOutBtn);
    }
}
