package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserRegistrationTestWithDDTAndCSV extends TestBase {
    HomePage homeObject;
    UserRegistrationPage registrationObject;
    LoginPage loginObject;

    CSVReader reader;



    @Test(priority = 1)
    public void userCanRegistrateSuccessfully() throws IOException, CsvValidationException, InterruptedException {
        // get path of CSV file;
        String CSV_file = System.getProperty("user.dir")+"/src/test/java/data/LoginData1.csv";
         reader = new CSVReader(new FileReader(CSV_file));

         String [] csvCell;

         // while loop will be executed until the last value in CSV file.

        while ((csvCell= reader.readNext()) != null)

        {
            String firstname = csvCell[0];
            String lastname = csvCell[1];
            String email = csvCell[2];
            String phoneNumber = csvCell[3];
            String password = csvCell[4];

            homeObject = new HomePage(driver);
            homeObject.openRegistrationPage();
            registrationObject = new UserRegistrationPage(driver);
            registrationObject.userRegistration(firstname,lastname,email,phoneNumber,password);
            Thread.sleep(2000);

            Assert.assertTrue(registrationObject.successMessage.getText().contains("Congratulations!"));
            registrationObject.userLogout();
            homeObject= new HomePage(driver);
            homeObject.openLoginPage();
            loginObject = new LoginPage(driver);
            loginObject.UserLogin(email, password);
            Thread.sleep(2000);
            Assert.assertTrue(registrationObject.lgout.getText().contains("Logout"));
            registrationObject.userLogout();

        }




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