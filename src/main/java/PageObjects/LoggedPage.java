package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class LoggedPage extends BasePage {

    private static final By AVATAR_ICON = By.cssSelector("li#wp-admin-bar-my-account > a");
    private static final By SIGN_OUT_LINK = By.linkText("Log Out");

    public LoggedPage(WebDriver driver) {
        super(driver);
    }

    public LogOutPage logOut() {
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(AVATAR_ICON)).build().perform();
        a.moveToElement(driver.findElement(SIGN_OUT_LINK)).click().build().perform();
        return new LogOutPage(driver);
    }
}
