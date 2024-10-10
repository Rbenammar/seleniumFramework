package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.time.Duration;

public class UserRegistrationTest extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginObject;


    @Test(priority = 1)
    public void userCanRegistrateSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration("ramirez", "biba", "speed120955level@gmail.com", "545581518", "12345678");

        Assert.assertTrue(registrationObject.successMessage.getText().contains("Congratulations!"));


    }

    @Test(dependsOnMethods = {"userCanRegistrateSuccessfully"})
    public void RegisteredUserCanLogout() {
        registrationObject.userLogout();

    }
    @Test(dependsOnMethods = {"RegisteredUserCanLogout"})
    public void RegisteredUserCanLogin ()
    {
        homeObject= new HomePage(driver);
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin("speed12level@gmail.com", "12345678");
        Assert.assertTrue(registrationObject.lgout.getText().contains("Logout"));
    }
}
// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//  wait.until(ExpectedConditions.urlContains("account/success"));
//  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='content']/p[contains(text(),'Congratulations!')]")));
// Now check if the message is displayed
//Assert.assertTrue(registrationObject.successMessage.isDisplayed(), "Success message is not displayed!");
// Assert.assertEquals(registrationObject.successMessage.getText(), "Congratulations! Your new account has been successfully created!", "Success message text does not match!");

//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//wait.until(ExpectedConditions.visibilityOf(registrationObject.successMessage));
// Assert.assertTrue(registrationObject.successMessage.isDisplayed(), "Success message is not displayed!");
// Assert.assertEquals(registrationObject.successMessage.getText(), "Congratulations! Your new account has been successfully created!", "Success message text does not match!");

//        System.out.println(registrationObject.successMessage.getText());
// registrationObject.userRegistration("hedksgo", "kkwgsdz", "toutdhdftra@gmail.com", "1233654");
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // 10 seconds timeout
//       Assert.assertTrue(registrationObject.successMessage.getText().contains("Your Account"));


 //<methods>
           // <include name="userCanRegistrateSuccessfully"/>
               // </methods>