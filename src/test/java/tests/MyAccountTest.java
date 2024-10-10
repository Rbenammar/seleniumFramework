package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{


    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginObject;
    MyAccountPage myAccountObject;

   String oldPassword = "8454494889";
    String newPassword = "147852";
    String firstName="ramirez";
    String lastName="biba";
    String email="speedlevel4586@gmail.com";
    String phoneNumber="545581518";




    @Test(priority = 1)
    public void userCanRegistrateSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registrationObject = new UserRegistrationPage(driver);
        registrationObject.userRegistration(firstName, lastName, email, phoneNumber, oldPassword);

        Assert.assertTrue(registrationObject.successMessage.getText().contains("Congratulations!"));


    }
    @Test(priority = 2)
    public void RegisteredUserCanChangePassword()
    {
        myAccountObject=new MyAccountPage(driver);
        registrationObject.openMyAccountPage();
        myAccountObject.OpenChangePasswordPage();
        myAccountObject.changePassword(newPassword);
        Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Success: Your password has been successfully updated"));


    }

    @Test(priority = 3)
    public void RegisteredUserCanLogout() {
        registrationObject.userLogout();

    }

    @Test(priority = 4)
    public void RegisteredUserCanLogin ()
    {
        homeObject= new HomePage(driver);
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email, newPassword);
        Assert.assertTrue(registrationObject.lgout.getText().contains("Logout"));
    }


}
