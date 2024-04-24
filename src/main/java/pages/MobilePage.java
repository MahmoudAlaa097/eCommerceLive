package pages;

import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MobilePage {
    private WebDriver driver;
    private By titleText = By.tagName("h1");
    private By dropdown = By.cssSelector("select[title='Sort By']");
    private By itemsList = By.cssSelector("li[class = 'item last']");
    private By sonyName = By.cssSelector("h2>a[title='Sony Xperia']");
    private By iphoneName = By.cssSelector("h2>a[title='IPhone']");
    private By sonyCost = By.id("product-price-1");
    private By sonyImg = By.id("product-collection-image-1");
    private By iphoneImg = By.id("product-price-2");
    private By addToCart = By.cssSelector("button.btn-cart");
    private By addToCompare = By.cssSelector("a[class=\"link-compare\"]");
    private By sonyCompare = RelativeLocator.with(addToCompare).below(sonyImg);
    private By iphoneCompare = RelativeLocator.with(addToCompare).below(iphoneImg);
    private By compareButton = By.cssSelector("button[title='Compare']");
    private By addToCartIphone = RelativeLocator.with(addToCart).below(iphoneImg);

    public MobilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle()
    {
        return driver.findElement(titleText).getText();
    }

    public void sortItems(String option)
    {
        new Select(driver.findElement(dropdown)).selectByVisibleText(option);
    }

    public boolean areItemsSorted()
    {
        List<String> itemsNames = driver.findElements(itemsList).
                stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> sortedName = itemsNames;
        Collections.sort(sortedName);

        return itemsNames.equals(sortedName);
    }

    public String getCost()
    {
        return driver.findElement(sonyCost).getText();
    }

    public SonyXperiaPage clickSonyXperia()
    {
        driver.findElement(sonyImg).click();
        return new SonyXperiaPage(driver);
    }

    public ShoppingCartPage addSonyToCart()
    {
        driver.findElements(addToCart).get(2).click();
        return new ShoppingCartPage(driver);
    }

    public void clickSonyAddToCompare()
    {
        driver.findElement(sonyCompare).click();
    }

    public String getSonyName()
    {
        return driver.findElement(sonyName).getText();
    }

    public void clickIphoneAddToCompare()
    {
        driver.findElement(iphoneCompare).click();
    }

    public String getIphoneName(){
        return driver.findElement(iphoneName).getText();
    }

    public ComparePage clickCompareButton(){
        driver.findElement(compareButton).click();
        return new ComparePage(driver);
    }

    public ShoppingCartPage clickAddToCartIphone()
    {
        Utils.waitElementIsClickable(driver, addToCartIphone);
        driver.findElement(addToCartIphone).click();
        return new ShoppingCartPage(driver);
    }
}
