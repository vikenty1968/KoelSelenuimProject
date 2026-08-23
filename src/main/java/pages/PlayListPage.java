package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlayListPage extends BasePage{
    public PlayListPage(WebDriver givenDriver){
        super(givenDriver);

    }

    private By plusBtn = By.cssSelector(".fa.create");
     private By createPlist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
     private By nameField = By.cssSelector("input[name='name']");
     private By successBanner = By.cssSelector(".success");
    public void clickPlusBtn(){
       click(plusBtn);
    }
    public void openSimplePlistForm(){
        click(createPlist);
    }
    public void enterPlistName(String pListName){
        type(nameField,pListName);
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys(Keys.ENTER);
    }
      public boolean isSuccessBannerDisplayed(){
        return isElementDisplayed(successBanner);
    }

}
