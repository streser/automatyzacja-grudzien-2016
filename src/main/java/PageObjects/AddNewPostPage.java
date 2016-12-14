package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddNewPostPage extends BasePage {
    private static final By TITLE_FIELD = By.cssSelector("input#title");
    private static final By TEXT_FIELD = By.cssSelector("body#tinymce");
    private static final By PUBLISH_BUTTON = By.cssSelector("input#publish");
    private static final By TEXT_FRAME = By.cssSelector("iframe#content_ifr");
    private static final By AVATAR_ICON = By.cssSelector("li#wp-admin-bar-my-account");
    private static final By SIGN_OUT_LINK = By.cssSelector("li#wp-admin-bar-logout > a");


    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage publishNewPost(String title, String text) {
        insertText(TITLE_FIELD, title);
        driver.switchTo().frame(driver.findElement(TEXT_FRAME));
        insertText(TEXT_FIELD, text);
        driver.switchTo().defaultContent();
        click(PUBLISH_BUTTON);
        return this;
    }

    public LogOutPage logOut() {
        Point coordinates = driver.findElement(AVATAR_ICON).getLocation();
        try {
            new Robot().mouseMove(coordinates.getX(),coordinates.getY()+80);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        waitForVisible(SIGN_OUT_LINK);
        click(SIGN_OUT_LINK);
        return new LogOutPage(driver);
    }
}
