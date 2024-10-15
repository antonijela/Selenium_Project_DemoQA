package Tests;

import Base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://demoqa.com/");
        homepagePage.scrollToElement(homepagePage.cards.get(5));
        homepagePage.clickOnCard("Book Store Application");
        sideBarPage.scrollToElement(sideBarPage.sidebar.getLast());
        sideBarPage.clickOnSideBar("Book Store");
        sideBarPage.selectSideBarOption("Login");
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }

    @Test (priority = 1)
    public void shouldLoginWihValidData(){
        loginPage.typeUsername("ana");
        loginPage.typePassword("A1!anademoqa");
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.logOutButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");
    }

    @Test (priority = 2)
    public void shouldNotLoginWithInvalidUsername(){
        loginPage.typeUsername("dfgmn");
        loginPage.typePassword("A1!anademoqa");
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertEquals(loginPage.notification.getText(), "Invalid username or password!");
    }

    @Test(priority = 3)
    public void shouldNotLoginWithInvalidPassword(){
        loginPage.typeUsername("ana");
        loginPage.typePassword("3456uyhgfdxcvb");
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertEquals(loginPage.notification.getText(), "Invalid username or password!");
    }

    @Test (priority = 4)
    public void shouldNotLoginWithInvalidData(){
        loginPage.typeUsername("dfgmn");
        loginPage.typePassword("dcfvn567");
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertEquals(loginPage.notification.getText(), "Invalid username or password!");
    }

    @Test (priority = 5)
    public void shouldNotLoginWithEmptyFields(){
        loginPage.usernameField.clear();
        loginPage.passwordField.clear();
        scrollToElement(loginPage.loginButton);
        loginPage.clickOnLoginButton();

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        loginPage.isErrorVisible();
    }
}
