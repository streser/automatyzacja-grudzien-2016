package pageobject;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-14.
 */
public abstract class AdminPage extends Page{
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        mouseOver(USER_ICON);
        mouseOver(LOGOUT_BUTTON);
        checkAndClick(LOGOUT_BUTTON);
    }
}
