package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CreateAccountPage {
    private WebDriver driver;
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailAddressField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirmation");
    private By registerButton = By.cssSelector("button[title=Register]");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFields(String firstname, String lastname, String emailAddress,
                            String password, String confirmPassword)
    {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstname);

        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastname);

        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(emailAddress);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public AccountPage clickRegister()
    {
        driver.findElement(registerButton).click();
        return new AccountPage(driver);
    }
}
