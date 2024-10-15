package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Base.BaseTest.driver;

public class WebTablesPage {

    public WebTablesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "rt-tr-group")
    public List<WebElement> tableRow;

    @FindBy(css = "[title=\"Delete\"]")
    public List<WebElement> deleteButton;

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(className = "rt-td")
    public List<WebElement> cell;

    public void getRowText() {
        for (int i = 0; i < tableRow.size(); i++) {
            boolean isEmpty = tableRow.get(i).getText().isBlank();
            System.out.println(isEmpty);
        }
    }

    public int rowsFilled() {
        int counter = 0;
        for (int i = 0; i < tableRow.size(); i++) {
            if (!tableRow.get(i).getText().isBlank()) {
                counter++;
            }
        }
        return counter;
    }

    public void deleteEachUser(){
        for (int i = deleteButton.size() - 1; i >= 0; i--){
            deleteButton.get(i).click();
        }
    }

    public void clickOnAddButton(){
        addButton.click();
    }

}