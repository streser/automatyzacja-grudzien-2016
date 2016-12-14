import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by User on 13-Dec-16.
 */
public abstract class Page {
    public WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }


    protected boolean isPostPublished(By locator) {
        if (driver.findElement(locator).isDisplayed()){
            return true;
        }
        return false;
    }

    protected void insertText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }


}
