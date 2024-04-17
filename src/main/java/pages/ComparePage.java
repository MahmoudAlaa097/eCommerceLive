package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComparePage {
    private WebDriver driver;
    private By sonyName = By.cssSelector("h2>a[title='Sony Xperia']");
    private By iphoneName = By.cssSelector("h2>a[title='IPhone']");

    public ComparePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewWindow()
    {
        for (String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            System.out.println(handle);
        }
    }

    public void waitUntilPageIsLoaded()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(sonyName));
    }

    public String getSonyName()
    {
        return driver.findElement(sonyName).getText();
    }

    public String getIphoneName(){
        return driver.findElement(iphoneName).getText();
    }
}
