package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private WebDriver driver;
    private By productQuantity = By.cssSelector("input[title='Qty']");
    private By updateButton = By.cssSelector("button[title = 'Update']");
    private By errorMessage = By.cssSelector("li.error-msg");
    private By emptyCartButton = By.cssSelector("button[title = 'Empty Cart']");
    private By cartIsEmpty = By.cssSelector("div[class = 'page-title']");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setQuantity(int quantity)
    {
        driver.findElement(productQuantity).clear();
        driver.findElement(productQuantity).sendKeys(Integer.toString(quantity));
        driver.findElement(updateButton).click();
    }

    public String getErrorMsg()
    {
        return driver.findElement(errorMessage).getText();
    }

    public void clickEmptyCart()
    {
        driver.findElement(emptyCartButton).click();
    }

    public String getEmptyCartMsg()
    {
        return driver.findElement(cartIsEmpty).getText();
    }
}
