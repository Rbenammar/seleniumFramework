package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{
    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-name")
    WebElement reviewNameTxt;
    @FindBy(id = "input-review")
    WebElement reviewTitleTxt;
    @FindBy(id = "button-review")
    WebElement submitReviewBtn;

    @FindBy(css = "label[for='rating-4-216860']")
    WebElement rating4;
    @FindBy(css = "div.alert.alert-success.alert-dismissible")
  public  WebElement successNotification;

    public void addProductReview(String reviewName, String reviewTitle )
    {

        setTextElement(reviewNameTxt,reviewName);
        setTextElement(reviewTitleTxt,reviewTitle);
        clickBtn(rating4);
        clickBtn(submitReviewBtn);

    }

}
