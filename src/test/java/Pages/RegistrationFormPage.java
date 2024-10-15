package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Base.BaseTest.driver;

public class RegistrationFormPage {

    public RegistrationFormPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "age")
    public WebElement ageField;

    @FindBy(id = "salary")
    public WebElement salaryField;

    @FindBy(id = "department")
    public WebElement departmentField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    //METHODS
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
    public void typeAge(String age){
        ageField.clear();
        ageField.sendKeys(age);
    }
    public void typeSalary(String salary){
        salaryField.clear();
        salaryField.sendKeys(salary);
    }
    public void typeDepartment(String department){
        departmentField.clear();
        departmentField.sendKeys(department);
    }
    public void clickOnSubmitButton(){
        submitButton.click();
    }


}
