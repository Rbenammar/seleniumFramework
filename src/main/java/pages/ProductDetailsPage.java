package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "entry_216816")
    public WebElement productNamebreadCrumb;
    @FindBy(css = "i.far.fa-heart")
     WebElement heartIconBtn;
    @FindBy(css = "a.btn.btn-secondary.btn-block[href*='wishlist']")
    WebElement viewWishListBtn;
    @FindBy(css = "use[xlink:href='#svg607770ac6af90ecf46964e8f4f1e1ff7']")
     WebElement svgIconBtn;

    @FindBy(css = "button.btn.btn-sm.btn-default.btn-compare[title='Compare this Product']")
    public WebElement compareButton;

   // @FindBy(css = "button.text.btn.btn-md.btn-secondary")
   @FindBy(xpath = "//*[@id=\"entry_216842\"]/button")
    public WebElement AddToCardBtn;



    public void AddProductToWishList ()
    {
        clickBtn(heartIconBtn);
    }

    public void OpenWishlistPage()
    {
        clickBtn(viewWishListBtn);
    }

    public void CompareProductBtn()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(compareButton));
        clickBtn(button);
    }

    public void AddToCard()
    {
        clickBtn(AddToCardBtn);
    }


}
