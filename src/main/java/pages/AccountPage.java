package pages;

import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class AccountPage {
    private WebDriver driver;
    private By welcomeMsg = By.className("hello");
    private By tvTab = By.cssSelector("li[class='level0 nav-2 last']");
    private By myWishlist = By.xpath("//a[not(@title) and .='My Wishlist']");
    private By myOrdersList = By.xpath("//div[@class='block-content'][1]/ul/li[4]/a");
    private By viewOrdersButton = By.xpath("//*[@class=\"a-center view last\"]/span/a[1]");
    private By orderStatus = By.xpath("//table//*[@class='status']/em");
    private By printOrder = By.className("link-print");
    private By reOrderButton = By.className("link-reorder");

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

    public void clickMyOrders()
    {
        Utils.waitElementIsClickable(driver, myOrdersList);
        driver.findElement(myOrdersList).click();
    }

    public String getStatus()
    {
        Utils.waitElementIsVisible(driver, orderStatus);
        return driver.findElement(orderStatus).getText();
    }

    public void clickViewOrders()
    {
        Utils.waitElementIsClickable(driver,viewOrdersButton);
        driver.findElement(viewOrdersButton).click();
    }

    public void clickPrintOrder()
    {
        Utils.waitElementIsClickable(driver, printOrder);
        driver.findElement(printOrder);
    }

    public ShoppingCartPage clickReOrder()
    {
        Utils.waitElementIsClickable(driver, reOrderButton);
        driver.findElement(reOrderButton).click();
        return new ShoppingCartPage(driver);
    }
}
