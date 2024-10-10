package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{
    String productName = "macbook pro";

SearchPage searchObject;
ProductDetailsPage detailsObject;

@Test
    public void UserCanSearchForProduct()
{
    searchObject = new SearchPage(driver);
    detailsObject = new ProductDetailsPage(driver);
    searchObject.ProductSearch(productName);
    //after you click on the search button, a page of search result is displayed
    searchObject.OpenProductDetailsPage(); //you select one of the product list
    Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
    Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);




}
}
