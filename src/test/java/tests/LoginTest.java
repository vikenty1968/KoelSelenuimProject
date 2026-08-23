package tests;
import pages.LoginPage;
import pages.HomePage;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)

public class LoginTest extends BaseTest {
    String myEmail = System.getenv("KOEL_EMAIL");
    String myPassword =System.getenv("KOEL_PASSWORD");
    String warningText="Please fill out this field.";
    LoginPage loginPage;


//    @BeforeMethod(alwaysRun = true)
//    public void createLoginPage() {
//
//        loginPage = new LoginPage(getDriver());
//    }

    @Test(groups = {"smoke","regression"})
    public void loginValidUser() {
       LoginPage loginPage =new LoginPage(getDriver());
        HomePage homePage = loginPage.loginUserSuccess(myEmail, myPassword);
        Assert.assertTrue(homePage.isLogOutBtnDisplayed());



    }

    @Test(dataProvider = "Invalid_Credentials",groups ={ "regression","index"},priority = 1)
    public void login(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginUser(email, password);
        Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        Assert.assertTrue(loginPage.isRegistrationLinkDisplayed());

    }

    @Test(dataProvider = "EmptyFields",groups = "regression",priority = 2)
    public void loginWithEmptyField(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginUser(email, password);
        if (email.isEmpty()) {
            Assert
                    .assertEquals(loginPage.emailWarningMessageDisplayed(), warningText);
        } else {
            Assert.assertEquals(loginPage.passwordWarningMessageDisplayed(), warningText);
        }
    }


    @DataProvider(name = "Invalid_Credentials")
    public Object[][] negativeData() {
        return new Object[][]{{"123@ru", "admin"},
                {"vikenty.plakhov@testpro.io", "admin12"}, {"email@e.com", "MEGAdelta06@"}};
    }

    @DataProvider(name = "EmptyFields")
    public Object[][] emptyFields() {
        return new Object[][]{{"", "MEGAdelta06@"}, {"vikenty.plakhov@testpro.io", ""}, {"", ""}};
    }
}
