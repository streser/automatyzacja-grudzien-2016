package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class PostsPage extends AdminPage {


    public static final By NEW_POST_BUTTON = By.cssSelector("#wpbody-content > div.wrap > h2 > a");
    public static final By TITLE_FIELD = By.id("title");
    public static final By TEXT_FIELD = By.xpath("//*[@id=\"content\"]");
    public static final By PUBLISH_CONFIRM = By.xpath("//*[@id=\"message\"]/p");
    public static final By PUBLISH_BUTTON = By.id("publish");

    public PostsPage(WebDriver driver) {
        super(driver);
    }

    public void addNewPost(String title, String text) {
        checkAndClick(NEW_POST_BUTTON);
        insertText(TITLE_FIELD,title);
        insertText(TEXT_FIELD,text);


        checkAndClick(PUBLISH_BUTTON);
        check(PUBLISH_CONFIRM);
    }

}
