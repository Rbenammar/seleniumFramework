package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginObject;

    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String phoneNumber = fakeData.number().digits(9);
    String password = fakeData.number().digits(8);


    @Test(priority = 1)
    public void userCanRegistrateSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(firstname,lastname,email,phoneNumber,password);
        System.out.println("the user data is : "+firstname +" " +lastname+ " "+ email+ " "+ phoneNumber+ " "+password);
 
        Assert.assertTrue(registrationObject.successMessage.getText().contains("Congratulations!"));


    }

    @Test(dependsOnMethods = {"userCanRegistrateSuccessfully"})
    public void RegisteredUserCanLogout() {
        registrationObject.userLogout();

    }

    @Test(dependsOnMethods = {"RegisteredUserCanLogout"})
    public void RegisteredUserCanLogin() {
        homeObject = new HomePage(driver);
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email, password);
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