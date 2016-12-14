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
        //driver.findElement(By.xpath("//*[@id=\"welcome-panel\"]/div/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.linkText("Write your first blog post")).click();
        return new AddNewPostPage(driver);
    }
}
