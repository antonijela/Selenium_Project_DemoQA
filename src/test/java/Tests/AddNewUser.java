package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewUser extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
        homepagePage.scrollToElement(homepagePage.cards.get(0));
        homepagePage.clickOnCard("Elements");
        sideBarPage.scrollToElement(sideBarPage.sidebar.get(1));
        sideBarPage.sidebar.get(0).click();
        sideBarPage.jsClick(sideBarPage.webTablesOption.get(0));
        scrollToElement(webTablesPage.tableRow.get(0));
        webTablesPage.deleteEachUser();
        Assert.assertEquals(webTablesPage.rowsFilled(), 0);
    }

    @Test(priority = 1)
    public void shouldAddNewUser() {
        scrollToElement(webTablesPage.addButton);
        webTablesPage.clickOnAddButton();
        registrationFormPage.typeFirstName("Ana");
        registrationFormPage.typeLastName("Gasic");
        registrationFormPage.typeEmail("test@mail.com");
        registrationFormPage.typeAge("35");
        registrationFormPage.typeSalary("1000");
        registrationFormPage.typeDepartment("Department");
        jsClick(registrationFormPage.submitButton);
        Assert.assertTrue(webTablesPage.tableRow.get(0).getText().contains("Ana"));
        Assert.assertEquals(webTablesPage.rowsFilled(), 1);
    }

    @Test(priority = 2)
    public void shouldAddMultipleUser() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            scrollToElement(webTablesPage.addButton);
            webTablesPage.clickOnAddButton();

            String firstName = excelReader.getStringData("Sheet1", i, 0);
            String lastName = excelReader.getStringData("Sheet1", i, 1);
            String email = excelReader.getStringData("Sheet1", i, 2);
            String age = excelReader.getStringData("Sheet1", i, 3);
            String salary = excelReader.getStringData("Sheet1", i, 4);
            String department = excelReader.getStringData("Sheet1", i, 5);

            registrationFormPage.typeFirstName(firstName);
            registrationFormPage.typeLastName(lastName);
            registrationFormPage.typeEmail(email);
            registrationFormPage.typeAge(age);
            registrationFormPage.typeSalary(salary);
            registrationFormPage.typeDepartment(department);
            jsClick(registrationFormPage.submitButton);

            Assert.assertTrue(webTablesPage.tableRow.get(i - 1).getText().contains(firstName));
        }
        Assert.assertEquals(webTablesPage.rowsFilled(), 4);
    }

    @Test(priority = 3)    public void shouldAddMultipleUser2() {
        int x = 0;
        for (int i = 1; i < excelReader.getLastRow("Sheet1"); i++) {
            scrollToElement(webTablesPage.addButton);
            webTablesPage.clickOnAddButton();
            String firstName = excelReader.getStringData("Sheet1", i, 0);
            String lastName = excelReader.getStringData("Sheet1", i, 1);
            String email = excelReader.getStringData("Sheet1", i, 2);
            String age = excelReader.getStringData("Sheet1", i, 3);
            String salary = excelReader.getStringData("Sheet1", i, 4);
            String department = excelReader.getStringData("Sheet1", i, 5);

            registrationFormPage.typeFirstName(firstName);
            registrationFormPage.typeLastName(lastName);
            registrationFormPage.typeEmail(email);
            registrationFormPage.typeAge(age);
            registrationFormPage.typeSalary(salary);
            registrationFormPage.typeDepartment(department);
            jsClick(registrationFormPage.submitButton);

            Assert.assertEquals(webTablesPage.rowsFilled(), i);
            Assert.assertEquals(webTablesPage.cell.get(x).getText(), firstName);
            Assert.assertEquals(webTablesPage.cell.get(x + 1).getText(), lastName);
            Assert.assertEquals(webTablesPage.cell.get(x + 2).getText(), age);
            Assert.assertEquals(webTablesPage.cell.get(x + 3).getText(), email);
            Assert.assertEquals(webTablesPage.cell.get(x + 4).getText(), salary);
            Assert.assertEquals(webTablesPage.cell.get(x + 5).getText(), department);

            x = x + 7;
        }
    }
}
