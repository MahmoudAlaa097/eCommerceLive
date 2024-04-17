package compare;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareTests extends BaseTests {
    @Test
    public void test() throws InterruptedException {
        // Click on 'Mobile' menu
        var mobilePage = homePage.clickMobile();
        // Add Sony Xperia to compare
        mobilePage.clickSonyAddToCompare();
        // Store its name
        String sonyName = mobilePage.getSonyName();
        // Add IPhone to compare
        mobilePage.clickIphoneAddToCompare();
        // Store its name
        String iphoneName = mobilePage.getIphoneName();
        // Click on compare button
        var comparePage = mobilePage.clickCompareButton();
        // Switch to pop-up window
        comparePage.switchToNewWindow();
        // Wait until page is loaded
        comparePage.waitUntilPageIsLoaded();
        // Verify that names are identical
        assertEquals(comparePage.getSonyName(), sonyName, "Sony name is incorrect");
        assertEquals(comparePage.getIphoneName(), iphoneName, "IPhone name is incorrect");
    }
}
