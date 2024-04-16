package cart;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTests extends BaseTests {
    @Test
    public void testPurchasingMoreThanProductQuantity()
    {
        // Click on 'Mobile' menu
        var mobilePage = homePage.clickMobile();
        // Click on 'ADD TO CART' for sony
        var shoppingCartPage = mobilePage.addSonyToCart();
        // Change quantity to 1000 and Click on 'UPDATE'
        shoppingCartPage.setQuantity(1000);
        // Verify error message
        assertEquals(shoppingCartPage.getErrorMsg(),
                "Some of the products cannot be ordered in requested quantity.",
                "Error message is incorrect");
        // Click on 'EMPTY CART'
        shoppingCartPage.clickEmptyCart();
        // Verify cart is empty
        assertEquals(shoppingCartPage.getEmptyCartMsg(),
                "SHOPPING CART IS EMPTY", "Cart is not empty");
    }
}
