package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By createAccount = By.cssSelector("a[title='Create an Account']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateAccountPage clickCreateAnAccount()
    {
        driver.findElement(createAccount).click();
        return new CreateAccountPage(driver);
    }
}
