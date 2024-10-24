package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PageBase;

public class ContactJulioTest extends TestBase {

    public HomePage homeObject;
   public  PageBase pageObject;

   @Test
   @Severity(SeverityLevel.CRITICAL)
   @Description("Contact Julio Test")
   @Link(name = "Jira Ticket", url = "http://google.com")
   public void userCanOpenContactJulio()
    {
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        homeObject = new HomePage(driver);
        pageObject = new PageBase(driver);
        homeObject.contactJolio();

    }
}
