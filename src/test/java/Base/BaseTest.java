package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    public static WebDriver driver;

    public HomepagePage homepagePage;
    public SideBarPage sideBarPage;
    public LoginPage loginPage;
    public WebTablesPage webTablesPage;
    public PracticeFormPage practiceFormPage;
    public RegistrationFormPage registrationFormPage;
    public TextBoxPage textBoxPage;

    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        homepagePage = new HomepagePage();
        sideBarPage = new SideBarPage();
        loginPage = new LoginPage();
        webTablesPage = new WebTablesPage();
        practiceFormPage = new PracticeFormPage();
        registrationFormPage = new RegistrationFormPage();
        textBoxPage = new TextBoxPage();
        excelReader = new ExcelReader("./TestDataWebTables.xlsx");

    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
