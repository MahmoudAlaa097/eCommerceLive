package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;
    private By welcomeMsg = By.className("hello");
    private By tvTab = By.cssSelector("li[class='level0 nav-2 last']");
    private By myWishlist = By.xpath("//a[not(@title) and .='My Wishlist']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeMsg()
    {
        return driver.findElement(welcomeMsg).getText();
    }

    public TvPage clickTvTab()
    {
        driver.findElement(tvTab).click();
        return new TvPage(driver);
    }

    public WishlistPage clickMyWishlist()
    {
        driver.findElement(myWishlist).click();
        return new WishlistPage(driver);
    }
}
