package purchase;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PurchaseTests extends BaseTests {
    @Test
    public void testPurchaseUsingAnExistingUser() throws InterruptedException {
        final String country = "United States";
        final String state = "New York";
        final String zip = "542896";
        final String address = "ABC";
        final String city = "New York";
        final String telephone = "12345678";
        final String FLAT_RATE = "$5.00";

        // Click on my account tab
        var loginPage = homePage.clickMyAccount();

        // Login
        var accountPage = loginPage.loginWithExistingUser();

        // Click My wishlist
        var wishlistPage = accountPage.clickMyWishlist();

        // Click 'ADD TO CART'
        var shoppingCartPage = wishlistPage.clickAddToCart();

        // Enter shipping information
        shoppingCartPage.selectCountry(country);
        shoppingCartPage.selectState(state);
        shoppingCartPage.setZipCode(zip);

        // Click Estimate
        shoppingCartPage.clickEstimate();

        // Verify flat rate is generated
        assertEquals(shoppingCartPage.getFlatRate(), FLAT_RATE, "Flat rate is incorrect");

        // Click Fixed Flat Rate
        shoppingCartPage.clickFixedFlatRate();

        // Click Update total
        shoppingCartPage.clickUpdateTotal();

        // Verify flat rate is added
        assertEquals(shoppingCartPage.getFlatRateIncluded(), FLAT_RATE, "Flat rate is not included");

       // Click 'PROCEED TO CHECKOUT'
        var checkoutPage = shoppingCartPage.clickProceedToCheckout();

        // Enter shipping information
        checkoutPage.setAddress(country);
        checkoutPage.selectState(state);
        checkoutPage.setZip(zip);
        checkoutPage.setAddress(address);
        checkoutPage.setCity(city);
        checkoutPage.setTelephone(telephone);

        // Click Continue
        checkoutPage.clickContinue();

        // Click shipping method continue
        checkoutPage.clickShippingMethodContinue();

        // Click Check/Money Order
        checkoutPage.clickCheckMoneyOrder();

        // Click Continue
        checkoutPage.clickPaymentContinue();

        // Click Place Order
        checkoutPage.clickPlaceOrder();

        // Verify order is generated
        assertTrue(checkoutPage.getSuccessMsg().contains("Your order # is: "),
                "Order number is not generated");
    }
}
