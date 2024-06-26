package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void goHome()
    {
        driver.get("http://live.techpanda.org/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
