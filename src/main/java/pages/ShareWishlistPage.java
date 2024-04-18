package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShareWishlistPage {
    private WebDriver driver;
    private By emailField = By.id("email_address");
    private By messageField = By.id("message");
    private By shareButton = By.cssSelector("button[title='Share Wishlist']");

    public ShareWishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email)
    {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void setMessage(String message)
    {
        driver.findElement(messageField).clear();
        driver.findElement(messageField).sendKeys(message);
    }

    public WishlistPage clickShareWishlist()
    {
        driver.findElement(shareButton).click();
        return new WishlistPage(driver);
    }
}
