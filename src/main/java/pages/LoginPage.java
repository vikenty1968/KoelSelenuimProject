package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
;
    private By emailInput = By.cssSelector("[type='email']");
    private By passwordInput = By.cssSelector("[type='password']");
    private By loginButton = By.cssSelector("[type='submit']");
    private By loginFormError = By.cssSelector("[data-testid='login-form'].error");
    private  By registrationLink=By.cssSelector("a[href='registration']");

  public HomePage loginUserSuccess(String email, String password){
        type(emailInput,email);
        type(passwordInput,password);
        click(loginButton);
        return new HomePage(driver);
    }
    public void loginUser(String email,String password){
      type(emailInput,email);
      type(passwordInput,password);
      click(loginButton);
    }
    public boolean isLoginErrorDisplayed(){
      return isElementDisplayed(loginFormError);
    }
    public boolean isRegistrationLinkDisplayed(){
        return isElementDisplayed(registrationLink);
    }
    public String emailWarningMessageDisplayed(){
     return   getWarningMessage(emailInput,"validationMessage");

    }
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//
//    String message = (String) js.executeScript("return arguments[0].validationMessage",loginPage.emailInput);
//    String lang = (String) js.executeScript("return navigator.language");
    public String passwordWarningMessageDisplayed(){
     return    getWarningMessage(passwordInput,"validationMessage");

    }
}
