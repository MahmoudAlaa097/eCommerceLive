package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HomePage {
    private WebDriver driver;
    private By titleText = By.tagName("h2");
    private By mobileTab = By.cssSelector("li[class = 'level0 nav-1 first']");
    private By accountTab = By.cssSelector("#header a[class*='skip-account']");
    private By myaccount = By.cssSelector("a[title='My Account']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public MobilePage clickMobile()
    {
        driver.findElement(mobileTab).click();
        return new MobilePage(driver);
    }

    public String getTitle()
    {
        return driver.findElement(titleText).getText();
    }

    public LoginPage clickMyAccount()
    {
        driver.findElement(accountTab).click();
        driver.findElement(myaccount).click();
        return new LoginPage(driver);
    }
}
