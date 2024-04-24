package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public final static String EMAIL = "mahmoudalaa1@testing.com";
    public final static String PASSWORD = "P@ssw0rd";

    public static void waitElementIsVisible(WebDriver driver, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitElementIsClickable(WebDriver driver, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
