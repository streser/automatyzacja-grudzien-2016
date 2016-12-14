import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddNewPostPage extends Page{
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public BlogPrewievPage publishNewPost(String tytulPostu, String trescPostu) {
        insertText(By.id("title"), tytulPostu);
        insertText(By.id("tinymce"), trescPostu);
        driver.findElement(By.id("publish")).click();
        return new BlogPrewievPage(driver);
    }

}
