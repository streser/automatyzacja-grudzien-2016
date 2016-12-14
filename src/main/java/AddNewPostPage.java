/**
 * Created by Administrator on 2016-12-13.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewPostPage extends Page {
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public void publishNewPost(String title, String text) {
        checkAndClick(By.cssSelector("#wpbody-content > div.wrap > h2 > a"));
        insertText(By.id("title"),"Title");
        checkAndClick(By.id("publish"));

    }

    public void LogOut() {

    }
}
