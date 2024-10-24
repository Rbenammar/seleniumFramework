package tests;
import data.LoadProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase2 {

//sauce Labs Configuration

   // public static final String USERNAME = LoadProperties.sauceLabsData.getProperty("username");
   // public static final String ACCESS_KEY = LoadProperties.sauceLabsData.getProperty("accesskey");
    // public static final String sauceURL = "https://" + USERNAME + ":" + ACCESS_KEY + LoadProperties.sauceLabsData.getProperty("seleniumURL");
    //public static final String sauceURL = "https://oauth-ramibenammar93-615f8:ca903a97-39f1-49df-872a-b2cb4540e816@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    public static String BaseURL = "https://ecommerce-playground.lambdatest.io/";

    protected ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    @BeforeClass
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setPlatformName("Windows 11");
//        browserOptions.setBrowserVersion("latest");

        // Sauce Labs specific options
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("username", "oauth-ramibenammar93-615f8");
//        sauceOptions.put("accessKey", "ca903a97-39f1-49df-872a-b2cb4540e816");
//        sauceOptions.put("build", "selenium-build-1234");
//        sauceOptions.put("name", "User Registration Test");

        // Add sauce options to browser options
       // browserOptions.setCapability("sauce:options", sauceOptions);

        // Sauce Labs URL
       // URL url = new URL("https://oauth-ramibenammar93-615f8:ca903a97-39f1-49df-872a-b2cb4540e816@ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        // Initialize RemoteWebDriver with the URL and browser options
        //WebDriver driverInstance = new RemoteWebDriver(url, browserOptions);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser);

        // Run on SauceLabs on Cloud
        System.out.println("Initializing WebDriver for browser: " + browser);
      //  driver.set(new RemoteWebDriver(new URL(BaseURL), caps));


        //Selenium Grid Cloud
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));

        if (getDriver() == null) {
            throw new IllegalStateException("Driver initialization failed!");
        }

        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
        getDriver().navigate().to(BaseURL);
    }
    public WebDriver getDriver() {
        return driver.get();

    }
    @AfterClass
    public void stopDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}

