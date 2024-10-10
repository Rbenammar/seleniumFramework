package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparePages;
import pages.ProductDetailsPage;
import pages.SearchPage;

import java.util.List;

public class CompareProductsTest extends TestBase{

    String firstproductName = "MacBook pro";
    String secondProductName = "Sony VAIO";

    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ComparePages compareObject;

    @Test(priority = 1)
    public void UserCanCompareProducts() throws InterruptedException {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.ProductSearch(firstproductName);
        compareObject = new ComparePages(driver);

        searchObject.ProductSearch("MacBook pro");



        //after you click on the search button, a page of search result is displayed
        searchObject.OpenProductDetailsPage(); //you select one of the product list
        Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(firstproductName));

        // Use JavaScriptExecutor to scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll into view the compare button directly from detailsObject
        js.executeScript("arguments[0].scrollIntoView(true);", detailsObject.compareButton);


       detailsObject.CompareProductBtn();

        searchObject.ProductSearch("Sony VAIO");
        searchObject.OpenProduct2DetailsPage();
        Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), secondProductName);

        // Use JavaScriptExecutor to scroll into view
        JavascriptExecutor jss = (JavascriptExecutor) driver;

        // Scroll into view the compare button directly from detailsObject
        jss.executeScript("arguments[0].scrollIntoView(true);", detailsObject.compareButton);

        detailsObject.CompareProductBtn();
        Thread.sleep(2000);

        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=product/compare");
        Thread.sleep(2000);

        Assert.assertTrue(compareObject.firstProductName.getText().contains("MacBook Pro"));
        Assert.assertTrue(compareObject.secondProductName.getText().contains("Sony VAIO"));




        for (WebElement row : compareObject.tableRows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));

            for (WebElement column : columns) {

                System.out.println(column.getText());

            }
        }
        Thread.sleep(2000);


    }

    @Test(priority = 2)
    public void UserCanClearCompareList() throws InterruptedException {
        JavascriptExecutor jss2 = (JavascriptExecutor) driver;

        // Scroll into view the compare button directly from detailsObject
        jss2.executeScript("arguments[0].scrollIntoView(true);", compareObject.removeFirstBtn);
        Thread.sleep(2000);
            compareObject.RemoveProductCompare();
            Assert.assertEquals(compareObject.noProductMessage.getText(), "You have not chosen any products to compare.");
    }

}
