package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddNewPostPage extends Page {
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public void addTitle(String title) {
        insertText(By.id("title"), title);
    }

    public void addContent(String content) {
        insertText(By.cssSelector("#content"), content);
    }

    public void clickPublish() {
        click(By.id("publish"));
    }

    public void publishNewPost(String title, String content) {
        addTitle(title);
        addContent(content);
        clickPublish();
    }
}
