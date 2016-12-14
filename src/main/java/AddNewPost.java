import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AddNewPost  extends Page{
    public AddNewPost(WebDriver driver) {
        super(driver);
    }

    public void CreatePost(String title, String content) {
        insertText(By.id("title"), title);
        clickElement(By.cssSelector("#content-html"));
        insertText(By.id("content"), content);
    }

    public void publishPost() {
        clickElement(By.id("publish"));
    }

    public void logOut() {
        tryLogOut();
    }
}
