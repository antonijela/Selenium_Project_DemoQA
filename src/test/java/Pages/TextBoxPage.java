package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static Base.BaseTest.driver;

public class TextBoxPage{

    public TextBoxPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "userName")
    public WebElement fullNameField;

    @FindBy (id = "userEmail")
    public WebElement emailField;

    @FindBy (id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy (id = "permanentAddress")
    public WebElement permanentAddressField;

    @FindBy (id = "submit")
    public WebElement submitButton;

    @FindBy (id = "name")
    public WebElement nameConfirm;

    @FindBy (id = "email")
    public WebElement emailConfirm;

    @FindBy (css = "#currentAddress.mb-1")
    public WebElement currentAddressConfirm;

    @FindBy (css = "#permanentAddress.mb-1")
    public WebElement permanentAddressConfirm;

    @FindBy (css = "[class=\"mr-sm-2 field-error form-control\"]")
    public WebElement errorValue;

    @FindBy (css = ".border.col-md-12.col-sm-12")
    public WebElement output;

    public void typeFullname(String fullname){
        fullNameField.clear();
        fullNameField.sendKeys(fullname);
    }
    public void typeEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void typeCurrentAddress(String currentAddress){
        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);
    }
    public void typePermanentAddress(String permanentAddress){
        permanentAddressField.clear();
        permanentAddressField.sendKeys(permanentAddress);
    }
    public void clickSubmitButton(){
        submitButton.click();
    }

  public void checkVisibility1(By locator) {
        boolean isOutputDisplayed = false;
        try {
            WebElement element = driver.findElement(locator);
            isOutputDisplayed = element.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(isOutputDisplayed);
    }

}
