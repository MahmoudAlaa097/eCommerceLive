package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class TvPage {
    private WebDriver driver;
    private By lgImg = By.id("product-collection-image-4");
    private By addToWishlist = By.cssSelector("a[class=link-wishlist]");
    private By lgWishlist = RelativeLocator.with(addToWishlist).below(lgImg);

    public TvPage(WebDriver driver) {
        this.driver = driver;
    }

    public WishlistPage clickLgAddToWishlist()
    {
        driver.findElement(lgWishlist).click();
        return new WishlistPage(driver);
    }
}
