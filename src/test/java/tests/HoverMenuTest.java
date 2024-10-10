package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegistrationPage;

public class HoverMenuTest extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registrationObject;


    @Test(priority = 1)
    public void UserCanHoverSubMenuMobileCases()
    {
        homeObject = new HomePage(driver);
        homeObject.hoverMobileCasesMenu();
    }
    @Test(priority = 2)
    public void UserCanLogoutt()
    {
        homeObject.logoutUser();
    }
    }

