package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class MainAdminPage extends AdminPage {

    private static final By POSTS_BUTTON = By.id("menu-posts");

    MainAdminPage(WebDriver driver) {
        super(driver);
    }

    public PostsPage goToPostPage() {
        checkAndClick(POSTS_BUTTON);
        return new PostsPage(driver);
    }
}
