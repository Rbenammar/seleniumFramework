package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Actions action;

    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void clickBtn(WebElement button) {
        button.click();
    }

    public void setTextElement(WebElement textElement, String value)
    {
        textElement.sendKeys(value);
    }

    public void scrollDown() {
        jse.executeScript("scrollBy(0,2500)");

    }
    public void clearText(WebElement element)
    {
        element.clear();
    }


}
