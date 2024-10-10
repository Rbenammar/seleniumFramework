package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddProductReviewTest extends TestBase{




        /*
        *1- User Registration
        *2- Search Product
        *3- add Review
        *4- Logout
         */

    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginObject;
    String productName = "MacBook Pro";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ProductReviewPage reviewObject;



    @Test(priority = 1)
    public void userCanRegistrateSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration("ramirez", "biba", "speed12567891level@gmail.com", "545581518", "12345678");

        Assert.assertTrue(registrationObject.successMessage.getText().contains("Congratulations!"));
    }


    @Test(priority = 2)
    public void UserCanSearchForProduct()
    {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.ProductSearch(productName);
        //after you click on the search button, a page of search result is displayed
        searchObject.OpenProductDetailsPage(); //you select one of the product list
        Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);

        reviewObject = new ProductReviewPage(driver);
        reviewObject.addProductReview("testRamiweb","This product is good i really appreciate it");
        Assert.assertTrue(reviewObject.successNotification.getText().contains("Thank you for your review"));
    }

    @Test(priority = 3)
    public void userCanLogoutt()
    {
homeObject.logoutUser();

    }


}
