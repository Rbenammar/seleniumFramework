package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageBase;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCardPage;

public class AddProductToShoppingCard extends TestBase {

    String productName = "MacBook";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ShoppingCardPage shoppingObject;
    PageBase pageObject;


    @Test(priority = 1)
    public void UserCanSearchWithAutoSuggest() {

        try {
            searchObject = new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest("macBook");
            detailsObject = new ProductDetailsPage(driver);
            Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
        } catch (Exception e) {
            System.out.println("Error Occured " + e.getMessage());
        }


    }

    @Test(priority = 2)
    public void UserCanAddProductToCard() throws InterruptedException {
        detailsObject = new ProductDetailsPage(driver);
        JavascriptExecutor jss3 = (JavascriptExecutor) driver;

        // Scroll into view the compare button directly from detailsObject
        jss3.executeScript("arguments[0].scrollIntoView(true);", detailsObject.AddToCardBtn);
        detailsObject.AddToCard();
        //Thread.sleep(2000);

    }

    @Test(priority = 3)
    public void UserCanUpdateQuantity() throws InterruptedException {
        shoppingObject = new ShoppingCardPage(driver);

        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=checkout/cart");
        // Thread.sleep(3000);
        Assert.assertTrue(shoppingObject.productName.getText().contains("MacBook"));
        shoppingObject.UpdateQuantity("2");
        System.out.println(" this is the total of price " + shoppingObject.TotalTxt.getText());
        Thread.sleep(2000);
        Assert.assertTrue(shoppingObject.TotalTxt.getText().contains("1,204"));
        shoppingObject.RemoveProduct();
        //Thread.sleep(3000);
        Assert.assertTrue(shoppingObject.checkEmpty.getText().contains("Your shopping cart"));

    }


}
