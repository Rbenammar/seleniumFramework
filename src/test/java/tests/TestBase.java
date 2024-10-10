package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.*;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
// the value of the parameters "browser" will be put as variable in the method start driver
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("user-agent=your-custom-user-agent");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

         //driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");





//        driver = new ChromeDriver();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
//        driver.navigate().to("https://demo.nopcommerce.com/");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8000));
    }



    @AfterSuite
    public void stopDriver() {
        driver.quit();

    }

    //Take screenshot when test case fails and add it to Screenshots Folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
if (result.getStatus()==ITestResult.FAILURE){
    System.out.println("Failed");
    System.out.println("Taking Screenshot....");
    Helper.captureScreenshot(driver, result.getName());

}
    }


}

//***********Code to bypass Captcha***/////
// Example in Selenium WebDriver
//WebDriver driver = new ChromeDriver();
//Map<String, Object> prefs = new HashMap<String, Object>();
//prefs.put("profile.default_content_setting_values.cookies", 2); // Disable cookies
//prefs.put("profile.default_content_setting_values.notifications", 2); // Disable notifications
//ChromeOptions options = new ChromeOptions();
//options.setExperimentalOption("prefs", prefs);
//options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
//driver = new ChromeDriver(options);//