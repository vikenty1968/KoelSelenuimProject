package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver givenDriver){
        this.driver=givenDriver;
        this.wait= new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }
    protected void type(By locator,String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected boolean isElementDisplayed(By locator){
      return   wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();

    }
    protected String getWarningMessage(By locator,String propertyName) {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(locator)).getDomProperty(propertyName);
    }


}
