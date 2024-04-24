package cart;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @Test
    public void testPurchaseUsingAnExistingUser() {
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

    @Test
    public void testReOrderPurchasedItem()
    {
        // Login
        var accountPage = homePage.clickMyAccount().loginWithExistingUser();
        // Click 'REORDER'
        var shoppingPage = accountPage.clickReOrder();
        // Set Quantity and Click 'Update'
        shoppingPage.setQuantity(10);
        // Verify Grand total is changed
        assertTrue(shoppingPage.getGrandTotal().contains("$6,150.00"),
                "Grand total is incorrect");
        // Click 'PROCEED TO CHECKOUT'
        var checkoutPage = shoppingPage.clickProceedToCheckout();

        // Complete billing and shipping information
        checkoutPage.clickContinue();
        checkoutPage.clickShippingMethodContinue();
        checkoutPage.clickCheckMoneyOrder();
        checkoutPage.clickPaymentContinue();
        checkoutPage.clickPlaceOrder();

        // Verify order is generated
        assertTrue(checkoutPage.getSuccessMsg().contains("Your order # is: "),
                "Order number is not generated");
    }

    @Test
    public void testDiscountCouponIsGenerated()
    {
        String coupon = "GURU50";
        // Login
        var homepage = homePage.clickMobile();
        // Add IPhone to cart
        var shoppingPage = homepage.clickAddToCartIphone();
        // Set coupon
        shoppingPage.setCoupon(coupon);
        // Click apply
        shoppingPage.clickApply();
        // Verify discount is applied
        assertEquals(shoppingPage.getDiscountText(),
                "DISCOUNT (" + coupon + ')',
                "Coupon is not applied");
    }
}
