package mobile;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MobileTests extends BaseTests {

    @Test
    public void testAreItemsSortedByName()
    {
        // Verify title of the page
        assertEquals(homePage.getTitle(),"THIS IS DEMO SITE FOR   ", "Home page title is incorrect");
        // Click on 'Mobile' menu
        var mobilePage = homePage.clickMobile();
        // Verify title of the page
        assertEquals(mobilePage.getTitle(), "MOBILE", "Mobile page title is incorrect");
        // Sort items by name
        mobilePage.sortItems("Name");
        // Verify items are sorted
        assertTrue(mobilePage.areItemsSorted());
    }
}
