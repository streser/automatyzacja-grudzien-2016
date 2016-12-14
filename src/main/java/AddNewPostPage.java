import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Administrator on 2016-12-13.
 */
public class AddNewPostPage extends Page {

    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public void addNewPost(String username, String post) {

        insertText(By.id("title"), username);
        insertText(By.xpath("//*[@class='wp-editor-area']"), post);
        driver.findElement(By.id("save-post")).click();
    }
}

