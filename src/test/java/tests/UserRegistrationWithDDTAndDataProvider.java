package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginObject;

@DataProvider(name = "testData")
public static Object [] [] userData()
{
    return new Object[][]{
            {"Rami","Ammar", "testramy12999@gmail.com", "913578468", "123456"},
            {"Ali","hamdouch", "testbomer17999@gmail.com", "913578445","12345678"}
    };


}

    @Test(priority = 1,alwaysRun = true, dataProvider = "testData")
    public void userCanRegisterSuccessfully(String fname, String lname, String email, String phoneNumber, String password)
    {
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        homeObject = new HomePage(driver);
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(fname, lname, email, phoneNumber, password);
        Assert.assertTrue(registrationObject.successMessage.getText().contains("Congratulations!"));
        registrationObject.userLogout();



    }

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
                {"testramy12999@gmail.com", "123456"},
                {"testbomer17999@gmail.com", "12345678"}
        };
    }

    @Test(dependsOnMethods = {"userCanRegisterSuccessfully"}, dataProvider = "loginData")
    public void RegisteredUserCanLogin (String email, String password)
    {
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        homeObject= new HomePage(driver);
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email,password);
        Assert.assertTrue(registrationObject.lgout.getText().contains("Logout"));
        registrationObject.userLogout();
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