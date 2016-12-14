import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPost goToPostPage() {
        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(By.cssSelector("#menu-posts > a > div.wp-menu-name"))).build().perform();
        action.moveToElement(driver.findElement(By.cssSelector("#menu-posts > ul > li:nth-child(3) > a"))).build().perform();
        action.click(driver.findElement(By.cssSelector("#menu-posts > ul > li:nth-child(3) > a"))).build().perform();

        return new AddNewPost(driver);

    }
}
