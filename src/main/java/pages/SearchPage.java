package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //@FindBy(name = "search")
    @FindBy(css = "input[name='search']")
    WebElement searchTxtBox;
    @FindBy(css = "button.type-text")
    WebElement searchBtn;
    @FindBy(css = "ul.dropdown-menu.autocomplete li.product-thumb")
    List<WebElement> productList;
    //@FindBy(linkText = "MacBook Pro")
    @FindBy(css = "img[alt='MacBook Pro']")
    WebElement productTitle;
    //@FindBy(linkText = "Sony VAIO")
    @FindBy(css = "img[alt='Sony VAIO']")
    WebElement productTitle2;


    public void ProductSearch(String productName) {

        searchTxtBox.clear();
        setTextElement(searchTxtBox, productName);
        clickBtn(searchBtn);

    }

    public void OpenProductDetailsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 seconds timeout
        wait.until(ExpectedConditions.visibilityOf(productTitle));
        clickBtn(productTitle);

    }
    public void OpenProduct2DetailsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 seconds timeout
        wait.until(ExpectedConditions.visibilityOf(productTitle2));
        clickBtn(productTitle2);

    }


    public void ProductSearchUsingAutoSuggest(String searchTxt) {

        try {
            searchTxtBox.clear();
            setTextElement(searchTxtBox, searchTxt);
            // Wait for the product list to be populated
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElements(productList));
            WebElement firstProductImage = productList.get(0).findElement(By.cssSelector("div.image img"));
            firstProductImage.click();


            //productList.getFirst().click();

        } catch (Exception e) {

            System.out.println("cannot locate the first element"+ e.getMessage());
        }


    }

}
