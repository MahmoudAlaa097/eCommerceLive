package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

public class ShoppingCartPage {
    private WebDriver driver;
    private By productQuantity = By.cssSelector("input[title='Qty']");
    private By updateButton = By.cssSelector("button[title = 'Update']");
    private By errorMessage = By.cssSelector("li.error-msg");
    private By emptyCartButton = By.cssSelector("button[title = 'Empty Cart']");
    private By cartIsEmpty = By.cssSelector("div[class = 'page-title']");
    private By checkout = By.cssSelector("ul[class*=top] button[title='Proceed to Checkout']");
    private By countryId = By.id("country");
    private By stateId = By.id("region_id");
    private By postCode = By.id("postcode");
    private By estimateButton = By.cssSelector("button[title='Estimate']");
    private By flatRate = By.cssSelector("label[for=s_method_flatrate_flatrate] span");
    private By updateTotalButton = By.name("do");
    private By flatRateIncluded = By.xpath("//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span");
    private By fixedRateButton = By.id("s_method_flatrate_flatrate");

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

    public CheckoutPage clickProceedToCheckout()
    {
        driver.findElement(checkout).click();
        return new CheckoutPage(driver);
    }

    private Select findDropDownElement(By locator)
    {
        return new Select(driver.findElement(locator));
    }

    public void selectCountry(String country)
    {
        findDropDownElement(countryId).selectByVisibleText(country);
    }

    public void selectState(String state)
    {
        findDropDownElement(stateId).selectByVisibleText(state);
    }

    public void setZipCode(String zipCode)
    {
        driver.findElement(postCode).sendKeys(zipCode);
    }

    public void clickEstimate()
    {
        Utils.waitElementIsVisible(driver, estimateButton);
        driver.findElement(estimateButton).click();
    }

    public String getFlatRate()
    {
        return driver.findElement(flatRate).getText();
    }

    public void clickUpdateTotal()
    {
        driver.findElement(updateTotalButton).click();
    }

    public String getFlatRateIncluded()
    {
        return driver.findElement(flatRateIncluded).getText();
    }

    public void clickFixedFlatRate()
    {
        driver.findElement(fixedRateButton).click();
    }
}
