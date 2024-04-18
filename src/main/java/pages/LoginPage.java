package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class LoginPage {
    private WebDriver driver;
    private By createAccount = By.cssSelector("a[title='Create an Account']");
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By loginButton = By.id("send2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateAccountPage clickCreateAnAccount()
    {
        driver.findElement(createAccount).click();
        return new CreateAccountPage(driver);
    }

    public AccountPage loginWithExistingUser()
    {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(Utils.EMAIL);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(Utils.PASSWORD);

        driver.findElement(loginButton).click();

        return new AccountPage(driver);
    }
}
