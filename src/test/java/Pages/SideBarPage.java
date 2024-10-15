package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBarPage extends BaseTest {

    public SideBarPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".left-pannel .header-wrapper .header-text")
    public List<WebElement> sidebar;


    @FindBy(css = ".btn-light#item-0 .text")
    public List<WebElement> sidebarOption;

    @FindBy(id = "item-3")
    public List<WebElement> webTablesOption;

    @FindBy(id = "c")
    public List<WebElement> elementsOptions;

    public void clickOnSideBar(String sidebarList){
        for (WebElement element : sidebar) {
            if (element.getText().equals(sidebarList)) {
                element.click();
                break;
            }
        }
    }

    public void selectSideBarOption(String sidebarSelect){
        for (WebElement element : sidebarOption) {
            if (element.getText().equals(sidebarSelect)) {
                jsClick(element);
                break;
            }
        }
    }

    public void clickOnElementsOption(int index){
        elementsOptions.get(index).click();
    }
    public void clickOnWebTablesOption(int index){
        webTablesOption.get(index).click();
    }
}
