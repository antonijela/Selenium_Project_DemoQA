package Tests;

import Base.BaseTest;
import Base.TestData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
        scrollToElement(homepagePage.cards.get(0));
        homepagePage.clickOnCard("Elements");
        sideBarPage.clickOnElementsOption(0);
    }

    @Test (priority = 1)
    public void shouldSubmitFormWithValidCredentials(){
        textBoxPage.typeFullname("Ana");
        textBoxPage.typeEmail("test@mail.com");
        textBoxPage.typeCurrentAddress("Address 1");
        textBoxPage.typePermanentAddress("Address 2");
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickSubmitButton();

        Assert.assertEquals(textBoxPage.nameConfirm.getText(), "Name:Ana");
        Assert.assertEquals(textBoxPage.emailConfirm.getText(), "Email:test@mail.com");
        Assert.assertEquals(textBoxPage.currentAddressConfirm.getText(), "Current Address :Address 1");
        Assert.assertEquals(textBoxPage.permanentAddressConfirm.getText(), "Permananet Address :Address 2");
    }

    @Test (priority = 2, dataProvider = "invalidEmailFormats", dataProviderClass = TestData.class)
    public void shouldNotSubmitFormWithInvalidEmailFormat(String invalidEmailFormats){
        textBoxPage.typeFullname("Ana");
        textBoxPage.typeEmail(invalidEmailFormats);
        textBoxPage.typeCurrentAddress("Address 1");
        textBoxPage.typePermanentAddress("Address 2");
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickSubmitButton();

        Assert.assertTrue(textBoxPage.errorValue.isDisplayed());
    }

    @Test(priority = 3)
    public void shouldNotSubmitFormWithEmptyFields(){
        textBoxPage.typeFullname("");
        textBoxPage.typeEmail("");
        textBoxPage.typeCurrentAddress("");
        textBoxPage.typePermanentAddress("");
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickSubmitButton();

        textBoxPage.checkVisibility1(By.id("name"));
        textBoxPage.checkVisibility1(By.id("email"));
        textBoxPage.checkVisibility1(By.cssSelector("#currentAddress.mb-1"));
        textBoxPage.checkVisibility1(By.cssSelector("#permanentAddress.mb-1"));

    }

    //Tests with priority 4, 5 and 6 are failing because form allows submission without filling all fields
    @Test(priority = 4, dataProvider = "oneFieldFilled", dataProviderClass = TestData.class)
    public void shouldNotSubmitFormWithOneFieldFilled(String fullname, String email, String address1, String address2){
        textBoxPage.typeFullname(fullname);
        textBoxPage.typeEmail(email);
        textBoxPage.typeCurrentAddress(address1);
        textBoxPage.typePermanentAddress(address2);
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickSubmitButton();

        Assert.assertFalse(textBoxPage.output.isDisplayed());
    }

    @Test(priority = 5, dataProvider = "twoFieldsFilled", dataProviderClass = TestData.class)
    public void shouldNotSubmitFormWithTwoFieldsFilled(String fullname, String email, String address1, String address2){
        textBoxPage.typeFullname(fullname);
        textBoxPage.typeEmail(email);
        textBoxPage.typeCurrentAddress(address1);
        textBoxPage.typePermanentAddress(address2);
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickSubmitButton();

        Assert.assertFalse(textBoxPage.output.isDisplayed());
    }

    @Test(priority = 6, dataProvider = "threeFieldsFilled", dataProviderClass = TestData.class)
    public void shouldNotSubmitFormWithThreeFieldsFilled(String fullname, String email, String address1, String address2){
        textBoxPage.typeFullname(fullname);
        textBoxPage.typeEmail(email);
        textBoxPage.typeCurrentAddress(address1);
        textBoxPage.typePermanentAddress(address2);
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickSubmitButton();

        Assert.assertFalse(textBoxPage.output.isDisplayed());
    }
}
