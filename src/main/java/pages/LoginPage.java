package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-email")
    WebElement emailtxtBox;
    @FindBy(id = "input-password")
    WebElement pwdtxtBox;
    @FindBy(css = "input.btn.btn-primary")
    WebElement loginBtn;

    public void UserLogin(String email, String password)
    {
        setTextElement(emailtxtBox,email);
        setTextElement(pwdtxtBox, password);
        clickBtn(loginBtn);

    }



}
