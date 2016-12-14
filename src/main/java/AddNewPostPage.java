import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddNewPostPage extends Page{

    //konstruktor
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    //metoda
    public void publishNewPost(String title, String text) {
        insertText(By.id("title"), title);
        insertText(By.id("content"), text);
        driver.findElement(By.id("publish")).click();
    }


}
