package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

public class CheckoutPage {
    private WebDriver driver;
    private By addressField = By.id("billing:street1");
    private By cityField = By.id("billing:city");
    private By countryField = By.id("billing:country_id");
    private By stateField = By.id("billing:region_id");
    private By zipField = By.id("billing:postcode");
    private By telephoneField = By.id("billing:telephone");
    private By continueButton = By.cssSelector("#billing-buttons-container button");
    private By methodContinueButton = By.cssSelector("#shipping-method-buttons-container button");
    private By checkMoneyOrderButton = By.id("p_method_checkmo");
    private By paymentContinue = By.cssSelector("#payment-buttons-container button");
    private By placeOrderButton = By.cssSelector("#review-buttons-container button");
    private By successMsg = By.xpath("//div[@class='col-main']/p[1]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setAddress(String address)
    {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    public void setCity(String city)
    {
        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);
    }

    public void setZip(String zip)
    {
        driver.findElement(zipField).clear();
        driver.findElement(zipField).sendKeys(zip);
    }

    public void setTelephone(String telephone)
    {
        driver.findElement(telephoneField).clear();
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    private Select findDropDownElement(By locator)
    {
        return new Select(driver.findElement(locator));
    }

    public void selectCountry(String country)
    {
        findDropDownElement(countryField).selectByVisibleText(country);
    }

    public void selectState(String city)
    {
        findDropDownElement(stateField).selectByVisibleText(city);
    }

    public void clickContinue()
    {
        Utils.waitElementIsClickable(driver, continueButton);
        driver.findElement(continueButton).click();
    }

    public void clickShippingMethodContinue()
    {
        Utils.waitElementIsClickable(driver,methodContinueButton);
        driver.findElement(methodContinueButton).click();
    }

    public void clickCheckMoneyOrder()
    {
        Utils.waitElementIsClickable(driver,checkMoneyOrderButton);
        driver.findElement(checkMoneyOrderButton).click();
    }

    public void clickPaymentContinue()
    {
        Utils.waitElementIsClickable(driver, paymentContinue);
        driver.findElement(paymentContinue).click();
    }

    public void clickPlaceOrder()
    {
        Utils.waitElementIsClickable(driver, placeOrderButton);
        driver.findElement(placeOrderButton).click();
    }

    public String getSuccessMsg()
    {
        Utils.waitElementIsVisible(driver, successMsg);
        return driver.findElement(successMsg).getText();
    }
}
