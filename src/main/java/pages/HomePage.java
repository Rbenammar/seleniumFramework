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
    WebElement megaMenu;
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



        // Hover over the Mega Menu
        action.moveToElement(megaMenu).perform();
        action.moveToElement(mobileCasesSubMenu);

        // Locate the "Mobile cases" submenu link and wait for it to be clickable



        // Click on the Mobile Cases submenu
        mobileCasesSubMenu.click();
    }

    public void logoutUser ()
    {
        action.moveToElement(myaccountMenu).perform();
        action.moveToElement(logoutSubMenu);
        logoutSubMenu.click();
    }
}
