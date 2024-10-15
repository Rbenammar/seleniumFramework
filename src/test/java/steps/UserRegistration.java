package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.CucumberTestbase;
import tests.TestBase;

public class UserRegistration extends CucumberTestbase {

    HomePage homeObject;
    UserRegistrationPage registerObject;

    @Given("^the user in the home page$")
    public void the_user_in_the_home_page() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();

    }

    @When("^I click on the register link$")
    public void I_click_on_the_register_link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }

    @When("^I enter the user data$")
    public void I_enter_the_user_data() {
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration("hamada", "kolou", "papi12@gmail.com", "49846148", "88552233");
    }

    @Then("^the registration page is displayed successfully$")
    public void the_registration_page_is_displayed_successfully() {
        registerObject.userLogout();
    }
}
