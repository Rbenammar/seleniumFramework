package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.util.concurrent.TimeUnit;

public class CucumberTestbase extends AbstractTestNGCucumberTests {

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
        }

        //  headless browser testing
        else if (browserName.equalsIgnoreCase("headless"))
        {
            DesiredCapabilities caps = new DesiredCapabilities();

            // Correctly specify the path to PhantomJS executable
            String phantomJsPath = System.getProperty("user.dir") + "/drivers/phantomjs.exe";
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomJsPath);

            // Add CLI arguments if needed
            String[] phantomJsArgs = {
                    "--web-security=no",
                    "--ignore-ssl-errors=yes",
                    "--ssl-protocol=any"
            };
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);

            // Initialize PhantomJSDriver with the specified capabilities
            driver = new PhantomJSDriver(caps);

        } else if (browserName.equalsIgnoreCase("chrome-headless")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            driver =  new ChromeDriver(options);
            
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");


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

