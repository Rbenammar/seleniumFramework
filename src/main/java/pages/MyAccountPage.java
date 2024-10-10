package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "My Account")
    WebElement myAccount;
    @FindBy(linkText = "Change your password")
    WebElement changePasswordLink;
    @FindBy(id = "input-password")
    WebElement newPasswordTxt;
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordTxt;
    @FindBy(css = "input[value='Continue']")
    WebElement submitPassword;
    @FindBy(css = "div.alert.alert-success")
   public WebElement resultLbl;


    public  void OpenChangePasswordPage()
    {
        clickBtn(changePasswordLink);
    }

    public void changePassword(String newPassword)
    {
setTextElement(newPasswordTxt, newPassword);
setTextElement(confirmPasswordTxt, newPassword);
clickBtn(submitPassword);


    }


}
