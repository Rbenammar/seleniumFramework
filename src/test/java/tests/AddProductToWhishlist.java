package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddProductToWhishlist extends TestBase{

    String productName = "MacBook Pro";

    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    WishlistPage wishListObject;
HomePage homeObject;
UserRegistrationPage registrationObject;

@Test(priority = 1)
public void userCanRegistrateSuccessfully() {
    homeObject = new HomePage(driver);
    homeObject.openRegistrationPage();
    registrationObject = new UserRegistrationPage(driver);
    registrationObject.userRegistration("ramirez", "biba", "speex12level@gmail.com", "545581518", "12345678");

    Assert.assertTrue(registrationObject.successMessage.getText().contains("Congratulations!"));
}

    @Test(priority = 2)
    public void UserCanSearchForProduct ()
    {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.ProductSearch(productName);
        //after you click on the search button, a page of search result is displayed
        searchObject.OpenProductDetailsPage(); //you select one of the product list
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));

    }
    @Test(priority = 3)
    public void UserCanAddProductToWishlist ()
    {
        wishListObject = new WishlistPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        detailsObject.AddProductToWishList();
        detailsObject.OpenWishlistPage();
        Assert.assertTrue(wishListObject.productName.getText().contains(productName));


    }
    @Test(priority = 4)
    public void UserCanRemoveFromWishlist () throws InterruptedException {
        wishListObject = new WishlistPage(driver);
        wishListObject.userRemoveProductFromWishlist();
        Thread.sleep(3000);

        Assert.assertTrue(wishListObject.wishListEmpty.getText().contains("result"));



    }


}

