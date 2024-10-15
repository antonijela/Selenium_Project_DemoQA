package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
    }

    @Test
    public void shouldHaveThreeRecords() {
        scrollToElement(homepagePage.cards.get(0));
        homepagePage.clickOnCard("Elements");
        scrollToElement(sideBarPage.sidebar.get(0));
        sideBarPage.clickOnWebTablesOption(0);
        Assert.assertEquals(webTablesPage.rowsFilled(), 3);
    }

    @Test
    public void shouldRemoveAllRecords() {
        scrollToElement(homepagePage.cards.get(0));
        homepagePage.clickOnCard("Elements");
        scrollToElement(sideBarPage.sidebar.get(0));
        sideBarPage.clickOnWebTablesOption(0);
        Assert.assertEquals(webTablesPage.rowsFilled(), 3);
        scrollToElement(webTablesPage.deleteButton.get(0));
        webTablesPage.deleteEachUser();
    }

}