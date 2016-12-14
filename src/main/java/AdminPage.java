import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AdminPage extends Page {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage goToNewPost() {
        driver.findElement(By.linkText("Write your first blog post")).click();
        return new AddNewPostPage(driver);
    }
}
