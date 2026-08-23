package tests;

import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

public class AuthenticatedTest extends BaseTest{
  protected   String email = System.getenv("KOEL_EMAIL");
    protected String password =System.getenv("KOEL_PASSWORD");
  //  protected HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    public void loginBeforeTest(){
        LoginPage loginPage=new LoginPage(getDriver());
       loginPage.loginUserSuccess(email,password);
    }

}
