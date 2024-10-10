package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

@FindBy(css = "td.text-left")
    public WebElement productName;

    //@FindBy(css = "i.fa fa-times")
    @FindBy(css = "a.btn.btn-light.btn-sm.text-danger")
    WebElement removeFromWishlist;

    @FindBy(css = "div.alert.alert-success.alert-dismissible")
    public WebElement successMessageWishList;

    @FindBy(xpath = "//p[text()='No results!']")
   public WebElement wishListEmpty;




    public void userRemoveProductFromWishlist()
    {
        clickBtn(removeFromWishlist);
    }



}
