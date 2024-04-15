package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By titleText = By.tagName("h2");
    private By mobileTab = By.cssSelector("li[class = 'level0 nav-1 first']");

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
}
