package tests;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class UserRegistrationTestWithDDTAndJSON extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginObject;


    @Test(priority = 1)
    public void userCanRegistrateSuccessfully() throws InterruptedException, IOException, ParseException {

        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();

        // Log extracted data
        System.out.println("Firstname: " + jsonReader.firstname);
        System.out.println("Lastname: " + jsonReader.lastname);
        System.out.println("Email: " + jsonReader.email);
        System.out.println("PhoneNumber: " + jsonReader.phoneNumber);
        System.out.println("Password: " + jsonReader.password);


        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(jsonReader.firstname, jsonReader.lastname, jsonReader.email, jsonReader.phoneNumber, jsonReader.password);
        Thread.sleep(2000);
        Assert.assertTrue(registrationObject.successMessage.getText().contains("Congratulations!"));
        registrationObject.userLogout();
        homeObject = new HomePage(driver);
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(jsonReader.email, jsonReader.password);
        Thread.sleep(2000);
        Assert.assertTrue(registrationObject.lgout.getText().contains("Logout"));
        registrationObject.userLogout();


    }


}
