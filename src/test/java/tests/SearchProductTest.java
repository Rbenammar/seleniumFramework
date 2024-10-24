package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{
    String productName = "MacBook Pro";

SearchPage searchObject;
ProductDetailsPage detailsObject;

@Test
    public void UserCanSearchForProduct()
{
    driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
    searchObject = new SearchPage(driver);
    detailsObject = new ProductDetailsPage(driver);
    searchObject.ProductSearch(productName);
    //after you click on the search button, a page of search result is displayed
    searchObject.OpenProductDetailsPage(); //you select one of the product list
    Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
    Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);




}
}
