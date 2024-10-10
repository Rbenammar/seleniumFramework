package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegistrationPage extends PageBase {


    public UserRegistrationPage(WebDriver driver) {
        super(driver); // Calls the constructor of the BasePage to pass the driver that is declared in PageBase
    }

//    @FindBy(id = "gender-male")
//    public WebElement genderRadioBtn;
    @FindBy(id = "input-firstname")
    WebElement fnTxtBox;
    @FindBy(id = "input-lastname")
    WebElement lnTxtBox;
    @FindBy(id = "input-email")
    WebElement emailTxtBox;
@FindBy(id = "input-telephone")
WebElement phoneNum;
    @FindBy(id = "input-password")
    WebElement pwdTxtBox;
    @FindBy(id = "input-confirm")
    WebElement confirmPwdTxtBox;
    @FindBy(xpath = "//*[@id='content']/form/div/div/div/label")
    WebElement agreeCheckbox;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement Confirm;
//    @FindBy(id = "register-button")
//    WebElement registerBtn;

//    @FindBy(css = "div.result")
   @FindBy(xpath = "//div[@id='content']/p[contains(text(),'Congratulations!')]")
    public WebElement successMessage;
    @FindBy(xpath = "//a[contains(@class, 'list-group-item') and contains(text(), 'Logout')]")
   public WebElement lgout;
    @FindBy(linkText = "My Account")
    WebElement myAccountLink ;
//@FindBy(linkText = "Logout")
//WebElement logoutLink;




    public void userRegistration(String firstName, String lastName, String email, String phoneNumber, String password)
    {
//        clickBtn(genderRadioBtn);
//        clickBtn(fnTxtBox);
//        clickBtn(lnTxtBox);
        setTextElement(fnTxtBox,firstName);
        setTextElement(lnTxtBox,lastName);
        setTextElement(emailTxtBox,email);
        setTextElement(phoneNum,phoneNumber);
        setTextElement(pwdTxtBox,password);
        setTextElement(confirmPwdTxtBox, password);

       clickBtn(agreeCheckbox);
        clickBtn(Confirm);
    }

    // Method to log out
    public void userLogout() {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)"); // Scroll to the bottom of the page
        }
        clickBtn(lgout); // Click the logout button
    }

    public void openMyAccountPage()
    {
        clickBtn(myAccountLink);


    }



    }





//    public void userLogout()
//    {
//        clickBtn(lgout);
//    }
    //        clickBtn(registerBtn)



