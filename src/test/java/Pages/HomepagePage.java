package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends BaseTest {

    public HomepagePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> cards;

    public void clickOnCard(String cardName){
        for (int i =0; i < cards.size(); i++){
            if(cards.get(i).getText().equals(cardName)){
                cards.get(i).click();
                break;
            }
        }
    }

}

