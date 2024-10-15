package Pages;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PracticeFormPage extends BaseTest {

    public PracticeFormPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(css = "[name=\"gender\"]")
    public List<WebElement> genderCheckbox;

    @FindBy(id = "userNumber")
    public WebElement mobileNumberField;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateField;

    @FindBy(xpath = "//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[5]")
    public WebElement dayOfBirth;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthDropdown;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearDropdown;

    @FindBy(id = "subjectsInput")
    public WebElement subjectField;

    @FindBy(css = "[type=\"checkbox\"] ")
    public List<WebElement> hoobiesCheckbox;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy(id = "react-select-3-input")
    public WebElement stateDropdown;

    @FindBy(id = "react-select-4-input")
    public WebElement cityDropdown;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement submitedFormNotification;

    @FindBy(className = "table-responsive")
    public WebElement submitedFormTable;

    //METODE
    public void typeFirstName(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }
    public void typeLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    public void typeEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void checkGenderCheckbox(String gender){
        switch (gender.toLowerCase()){
            case "male": jsClick(genderCheckbox.get(0)); break;
            case "female": jsClick(genderCheckbox.get(1)); break;
            case "other": jsClick(genderCheckbox.get(2)); break;
            default: throw new IllegalArgumentException("Invalid gender option: " + gender);
        }
    }
    public void typeMobileNumber(String mobileNumber){
        mobileNumberField.clear();
        mobileNumberField.sendKeys(mobileNumber);
    }
    public void selectDayOfBirth(){
        dateField.click();
        dayOfBirth.click();
    }
    public void selectMonth(String month) {
        dateField.click();
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);
    }
    public void selectYear(String year) {
        dateField.click();
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);
    }
    public void typeSubject(String subject){
        subjectField.clear();
        subjectField.sendKeys(subject);
    }
    public void checkEachHoobieCheckbox(){
        for (WebElement checkbox : hoobiesCheckbox) {
            jsClick(checkbox);
        }
    }
    public void uploadPicture(String location){
        String imagePath = System.getProperty("user.dir") + location;
        uploadPicture.sendKeys(imagePath);
    }
    public void typeCurrentAddress(String currentAddress){
        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);
    }
    public void inputState(String state){
        stateDropdown.sendKeys(state);
        stateDropdown.sendKeys(Keys.ENTER);
    }
    public void inputCity(String city){
        cityDropdown.sendKeys(city);
    }
    public void clickOnSubmitButton(){
        submitButton.click();
    }

}
