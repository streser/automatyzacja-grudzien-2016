package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.awt.*;

/**
 * Created by Administrator on 2016-12-14.
 */
public abstract class LoggedPage extends BasePage {

    private static final By AVATAR_ICON = By.cssSelector("li#wp-admin-bar-my-account");
    private static final By SIGN_OUT_LINK = By.cssSelector("li#wp-admin-bar-logout > a");

    public LoggedPage(WebDriver driver) {
        super(driver);
    }

    public LogOutPage logOut() {
        Point coordinates = driver.findElement(AVATAR_ICON).getLocation();
        try {
            new Robot().mouseMove(coordinates.getX(), coordinates.getY() + 80);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        waitForVisible(SIGN_OUT_LINK);
        click(SIGN_OUT_LINK);
        return new LogOutPage(driver);
    }
}
