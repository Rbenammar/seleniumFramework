package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationParallelTesting extends TestBase2 {
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
        homeObject = new HomePage(getDriver());
        homeObject.openRegistrationPage();
        registrationObject = new UserRegistrationPage(getDriver());
        registrationObject.userRegistration(firstname, lastname, email, phoneNumber, password);
        System.out.println("the user data is : " + firstname + " " + lastname + " " + email + " " + phoneNumber + " " + password);

        Assert.assertTrue(registrationObject.successMessage.getText().contains("Congratulations!"));


    }

    @Test(dependsOnMethods = {"userCanRegistrateSuccessfully"})
    public void RegisteredUserCanLogout() {
        registrationObject.userLogout();

    }

    @Test(dependsOnMethods = {"RegisteredUserCanLogout"})
    public void RegisteredUserCanLogin() {
        homeObject = new HomePage(getDriver());
        homeObject.openLoginPage();
        loginObject = new LoginPage(getDriver());
        loginObject.UserLogin(email, password);
        Assert.assertTrue(registrationObject.lgout.getText().contains("Logout"));
    }
}
