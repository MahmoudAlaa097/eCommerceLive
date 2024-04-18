package wishlist;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WishlistTests extends BaseTests {
    @Test
    public void testShareWishlistWithOthers()
    {
        final String FIRSTNAME = "Mahmoud";
        final String LASTNAME = "Alaa";
        final String EMAIL = "Mahmoudalaa333@testing.com";
        final String PASSWORD = "P@ssw0rd";
        final String CONFIRM = "P@ssw0rd";

        // Click on account tab & choose my account
        var loginPage = homePage.clickMyAccount();
        // Click create an account
        var createAccount = loginPage.clickCreateAnAccount();
        // Fill required fields
        createAccount.fillFields(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, CONFIRM);
        // Click register
        var accountPage = createAccount.clickRegister();
        // Verify registration
        assertEquals(accountPage.getWelcomeMsg(),
                "Hello, " + FIRSTNAME + " " + LASTNAME + "!",
                "Registration failed");
        // Go to TV menu
        var tvPage = accountPage.clickTvTab();
        // Add product to wishlist
        var wishlistPage = tvPage.clickLgAddToWishlist();
        // Click 'SHARE WISHLIST'
        var shareWishlistPage = wishlistPage.clickShareWishlist();
        // Enter Email
        shareWishlistPage.setEmail("ma7moudalaa097@gmail.com");
        // Enter Message
        shareWishlistPage.setMessage("Shared Product");
        // Click 'SHARE WISHLIST'
        wishlistPage = shareWishlistPage.clickShareWishlist();
        // Verify wishlist is shared
        assertEquals(wishlistPage.getSuccessMsg(), "Your Wishlist has been shared.",
                "Product is not shared");
    }
}
