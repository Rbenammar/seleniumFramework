package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutomSuggest extends TestBase {

    String productName = "MacBook";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;

    @Test
    public void UserCanSearchWithAutoSuggest() {

        try {
            searchObject =new SearchPage(driver);
            searchObject.ProductSearchUsingAutoSuggest("macBook");
            detailsObject=new ProductDetailsPage(driver);
            Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
        } catch (Exception e) {
            System.out.println("Error Occured " + e.getMessage());
        }


    }
}
