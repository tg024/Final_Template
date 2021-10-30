package Meta;

import Pages.RegistrationPage;
import Utils.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static DataObject.RegisterData.firstName;
import static DataObject.RegisterData.lastName;

public class RegTest {
    WebDriver driver;
    @BeforeMethod(description = "Configure browser before tests")
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.facebook.com/");
        Thread.sleep(2000);
    }
    @Test (retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register with valid credentials")
    public void testLogin() throws InterruptedException {
        RegistrationPage home = new RegistrationPage(driver);
        home
                .GotoCreateAccount()
                .FillFirstName(firstName)
                .FillLastName(lastName);

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
