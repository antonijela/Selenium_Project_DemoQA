package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://demoqa.com/");
        homepagePage.scrollToElement(homepagePage.cards.get(5));
        homepagePage.clickOnCard("Book Store Application");
        sideBarPage.clickOnSideBar("Forms");
        sideBarPage.selectSideBarOption("Practice Form");
    }

    @Test(priority = 1)
    public void shouldSubmitPracticeFormWithValidData(){
        practiceFormPage.typeFirstName("Ana");
        practiceFormPage.typeLastName("Gasic");
        practiceFormPage.typeEmail("test@mail.com");
        practiceFormPage.scrollToElement(practiceFormPage.genderCheckbox.get(0));
        practiceFormPage.checkGenderCheckbox("female");
        practiceFormPage.typeMobileNumber("0123456789");
        practiceFormPage.selectDayOfBirth();
        practiceFormPage.selectMonth("June");
        practiceFormPage.selectYear("1995");
        practiceFormPage.typeSubject("engleski");
        practiceFormPage.checkEachHoobieCheckbox();
        practiceFormPage.uploadPicture("/images/avatar.jpg");
        practiceFormPage.typeCurrentAddress("Address 1");
        practiceFormPage.inputState("Rajasthan");
        practiceFormPage.inputCity("Jaipur");
        practiceFormPage.clickOnSubmitButton();
        Assert.assertEquals(practiceFormPage.submitedFormNotification.getText(), "Thanks for submitting the form");
        Assert.assertTrue(practiceFormPage.submitedFormTable.isDisplayed());
    }

    @Test (priority = 2)
    public void shouldSubmitFormWithOnlyRequiredFields(){
        practiceFormPage.typeFirstName("Ana");
        practiceFormPage.typeLastName("Gasic");
        practiceFormPage.scrollToElement(practiceFormPage.genderCheckbox.get(0));
        practiceFormPage.checkGenderCheckbox("female");
        practiceFormPage.typeMobileNumber("0123456789");
        practiceFormPage.scrollToElement(practiceFormPage.submitButton);
        practiceFormPage.clickOnSubmitButton();
        Assert.assertEquals(practiceFormPage.submitedFormNotification.getText(), "Thanks for submitting the form");
        Assert.assertTrue(practiceFormPage.submitedFormTable.isDisplayed());
    }

    @Test (priority = 3)
    public void shouldNotSubmitFormWithEmptyFields(){
        practiceFormPage.firstNameField.clear();
        practiceFormPage.lastNameField.clear();
        practiceFormPage.emailField.clear();
        practiceFormPage.mobileNumberField.clear();
        practiceFormPage.dateField.clear();
        practiceFormPage.subjectField.clear();
        practiceFormPage.currentAddressField.clear();
        practiceFormPage.scrollToElement(practiceFormPage.submitButton);
        practiceFormPage.clickOnSubmitButton();
        Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());
    }

    @Test(priority = 4)
    public void shouldNotSubmitFormWithInvalidEmail(){
        practiceFormPage.typeFirstName("Ana");
        practiceFormPage.typeLastName("Gasic");
        practiceFormPage.typeEmail("test@mail");
        practiceFormPage.scrollToElement(practiceFormPage.genderCheckbox.get(0));
        practiceFormPage.checkGenderCheckbox("female");
        practiceFormPage.typeMobileNumber("0123456789");
        practiceFormPage.selectDayOfBirth();
        practiceFormPage.selectMonth("June");
        practiceFormPage.selectYear("1995");
        practiceFormPage.typeSubject("engleski");
        practiceFormPage.checkEachHoobieCheckbox();
        practiceFormPage.uploadPicture("/images/avatar.jpg");
        practiceFormPage.typeCurrentAddress("Address 1");
        practiceFormPage.inputState("Rajasthan");
        practiceFormPage.inputCity("Jaipur");
        practiceFormPage.clickOnSubmitButton();
        Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());
    }
    @Test (priority = 5)
    public void shouldNotSubmitFormWithInvalidMobileNumber(){
        practiceFormPage.typeFirstName("Ana");
        practiceFormPage.typeLastName("Gasic");
        practiceFormPage.scrollToElement(practiceFormPage.genderCheckbox.get(0));
        practiceFormPage.checkGenderCheckbox("female");
        practiceFormPage.typeMobileNumber("f3g4r5treer4");
        practiceFormPage.scrollToElement(practiceFormPage.submitButton);
        practiceFormPage.clickOnSubmitButton();
        Assert.assertTrue(practiceFormPage.submitButton.isDisplayed());
    }

}
