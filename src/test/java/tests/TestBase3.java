package tests;

import data.LoadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase3 {


    //sauce Labs Configuration

    public static final String USERNAME = LoadProperties.sauceLabsData.getProperty("username");
    public static final String ACCESS_KEY = LoadProperties.sauceLabsData.getProperty("accesskey");
   // public static final String sauceURL = "https://" + USERNAME + ":" + ACCESS_KEY + LoadProperties.sauceLabsData.getProperty("seleniumURL");
    public static final String sauceURL = "https://oauth-ramibenammar93-615f8:ca903a97-39f1-49df-872a-b2cb4540e816@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    public static String BaseURL = "https://ecommerce-playground.lambdatest.io/";

    protected ThreadLocal<RemoteWebDriver> driver = null;
    @BeforeClass
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver = new ThreadLocal<>();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser);

        // Run on SauceLabs on Cloud
        System.out.println("Initializing WebDriver for browser: " + browser);
        driver.set(new RemoteWebDriver(new URL(sauceURL), caps));

        if (getDriver() == null) {
            throw new IllegalStateException("Driver initialization failed!");
        }

        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

