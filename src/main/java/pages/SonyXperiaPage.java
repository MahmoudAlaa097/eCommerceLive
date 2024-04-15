package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SonyXperiaPage {
    private WebDriver driver;
    private By cost = By.id("product-price-1");

    public SonyXperiaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCost()
    {
        return driver.findElement(cost).getText();
    }
}
