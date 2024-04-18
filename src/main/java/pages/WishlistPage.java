package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
    private WebDriver driver;
    private By shareWishlist = By.name("save_and_share");
    private By successMsg = By.cssSelector("li[class='success-msg']");
    private By addToCartButton = By.cssSelector("button[title='Add to Cart']");

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShareWishlistPage clickShareWishlist()
    {
        driver.findElement(shareWishlist).click();
        return new ShareWishlistPage(driver);
    }

    public String getSuccessMsg()
    {
        return driver.findElement(successMsg).getText();
    }

    public ShoppingCartPage clickAddToCart()
    {
        driver.findElement(addToCartButton).click();
        return new ShoppingCartPage(driver);
    }
}
