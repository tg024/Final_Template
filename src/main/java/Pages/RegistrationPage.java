package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By CreateAccBTn = By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[1]/form/div[5]/a");
    By firstNameInput = By.name("firstname");
    By lastNameInput = By.name("lastname");
    @Step("Click Create Account Button")
    public RegistrationPage GotoCreateAccount() throws InterruptedException {
        driver.findElement(CreateAccBTn).click();
        Thread.sleep(2000);
        return this;
    }
    @Step("Fill First Name: {0}")
    public RegistrationPage FillFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }
    @Step("Fill Last Name: {0}")
    public RegistrationPage FillLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }
}
