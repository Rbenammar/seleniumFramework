package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCardPage extends PageBase {
    public ShoppingCardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "MacBook")
   public WebElement productName;
    @FindBy(css = ".form-control")
  public   WebElement quatityTxt;

    @FindBy(css = "button.btn.btn-primary")
   public WebElement updateBtn;
    @FindBy(css = ".btn.btn-danger")
    public WebElement removeBtn;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]")
   public WebElement TotalTxt;
    @FindBy(xpath = "//*[@id=\"content\"]/p")
   public WebElement checkEmpty;



    public void UpdateQuantity(String quantity) {
        clearText(quatityTxt);
        setTextElement(quatityTxt, quantity);
        clickBtn(updateBtn);
    }

    public void RemoveProduct()
    {
        clickBtn(removeBtn);
    }


}
