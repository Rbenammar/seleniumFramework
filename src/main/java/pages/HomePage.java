package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver)
    {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }





    @FindBy(xpath = "//*[@id='column-right']/div/a[2]")
    WebElement registerLink;

    @FindBy(xpath = "//*[@id='column-right']/div/a[1]")
    WebElement loginLink;

    @FindBy(linkText = "Jolio Balia")
    WebElement contactJolioBalia;
@FindBy(css = ".nav-item.dropdown-hoverable.mega-menu")
    public WebElement mega ;
@FindBy(css = "a[title='Mobile cases']")
WebElement mobileCasesSubMenu;
    @FindBy(css = "a.nav-link.dropdown-toggle.active[href*='route=account/account']")
    WebElement myaccountMenu;
    @FindBy(xpath = "//a[.//span[text()=' Logout ']]")
    WebElement logoutSubMenu;



//    @FindBy(xpath = "//a[text()='Login']")
//    WebElement loginLink;
//    @FindBy(linkText = "login")
//    WebElement loginLink;

    public void openRegistrationPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // 10 seconds wait
        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        registerLink.click();
    }
    public void openLoginPage()
    {
        clickBtn(loginLink);
    }
    public void contactJolio()
    {
        scrollDown();
        clickBtn(contactJolioBalia);
    }

    public void hoverMobileCasesMenu()
    {
        try {


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
// Wait until the mega menu is visible and then hover

            WebElement megaElement = wait.until(ExpectedConditions.visibilityOf(mega));
            // Hover over the Mega Menu
            Actions action = new Actions(driver);
            action.moveToElement(megaElement).perform();
            action.moveToElement(mobileCasesSubMenu).click().perform();

            // Locate the "Mobile cases" submenu link and wait for it to be clickable


            // Click on the Mobile Cases submenu
            mobileCasesSubMenu.click();
        } catch (Exception e) {
            System.out.println("Error interacting with menu: " + e.getMessage());
        }
    }


    public void logoutUser ()
    {
        action.moveToElement(myaccountMenu).perform();
        action.moveToElement(logoutSubMenu);
        logoutSubMenu.click();
    }
}
