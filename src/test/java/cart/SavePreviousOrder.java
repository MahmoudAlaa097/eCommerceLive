package cart;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SavePreviousOrder extends BaseTests {
    @Test
    public void testSavingPreviousOrder()
    {
        // Login
        var accountPage = homePage.clickMyAccount().loginWithExistingUser();

        // Click My Orders
        accountPage.clickMyOrders();

        // Verify that previously added order status is pending
        assertEquals(accountPage.getStatus(), "Pending", "Order is not added");

        // Click View Orders
        accountPage.clickViewOrders();

        // Click Print Order
        accountPage.clickPrintOrder();
    }
}
