package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.PageBase;

public class ContactJulioTest extends TestBase {

    public HomePage homeObject;
   public  PageBase pageObject;

   @Test
   public void userCanOpenContactJulio()
    {
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        homeObject = new HomePage(driver);
        pageObject = new PageBase(driver);
        homeObject.contactJolio();

    }
}
