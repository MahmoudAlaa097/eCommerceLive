package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MobilePage {
    private WebDriver driver;
    private By titleText = By.tagName("h1");
    private By dropdown = By.cssSelector("select[title='Sort By']");
    private By itemsList = By.cssSelector("li[class = 'item last']");
    private By sonyCost = By.id("product-price-1");
    private By sonyMobile = By.id("product-collection-image-1");
    private By addToCart = By.cssSelector("button.btn-cart");

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

    public SonyXperiaPage clickSonySperia()
    {
        driver.findElement(sonyMobile).click();
        return new SonyXperiaPage(driver);
    }

    public ShoppingCartPage addSonyToCart()
    {
        driver.findElements(addToCart).get(2).click();
        return new ShoppingCartPage(driver);
    }
}
