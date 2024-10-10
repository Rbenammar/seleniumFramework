package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparePages extends PageBase{
    public ComparePages(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "MacBook Pro")
   public WebElement firstProductName;
    @FindBy(linkText = "Sony VAIO")
  public   WebElement secondProductName;
    @FindBy(css = "table.table.table-responsive.table-bordered")
   public WebElement productComparisonTable;
    @FindBy(css = "table.table-responsive.table-bordered tr")
    public List<WebElement> tableRows;

    @FindBy(css = "a[href*='remove=45']")
    public WebElement removeFirstBtn;
    @FindBy(css = "a[href*='remove=46']")
    WebElement removeSecondBtn;
    @FindBy(xpath = "//p[text()='You have not chosen any products to compare.']")
   public  WebElement noProductMessage;


public void RemoveProductCompare()
{
    clickBtn(removeFirstBtn);
    clickBtn(removeSecondBtn);
}


}
