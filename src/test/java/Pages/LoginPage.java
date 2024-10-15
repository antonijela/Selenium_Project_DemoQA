package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LoginPage extends BaseTest {

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(), \"Log out\")]")
    public WebElement logOutButton;

    @FindBy(css = ".col-md-12.col-sm-12")
    public WebElement notification;

    @FindBy(css = ".is-invalid")
    public List<WebElement> errorValue;

    public void typeUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void typePassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }
    public void isErrorVisible() {
        for (WebElement error : errorValue) {
            Assert.assertTrue(error.isDisplayed());
        }
    }
}
