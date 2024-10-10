package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

@FindBy(id = "input-payment-firstname")
    WebElement firstNametxt;
    @FindBy(id = "input-payment-lastname")
    WebElement lastNameTxt;
    @FindBy(id = "input-payment-address-1")
    WebElement adressTxt;
    @FindBy(id = "input-payment-city")
    WebElement cityTxt;

    @FindBy(id = "input-payment-postcode")
    WebElement postCodeTxt;
    @FindBy(id = "input-payment-country")
    WebElement countrySelect;
    @FindBy(id = "input-payment-zone")
    WebElement regionSelect;
    @FindBy(xpath = "\"//label[@for='input-agree']\"")
    WebElement agreeCheckBox;
    @FindBy(id = "button-save")
    WebElement continueBtn;







}
