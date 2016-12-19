package PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Pawel_D on 2016-12-14.
 */
public abstract class AdminPage extends Page {

    public static final String XPATH_USER = "wp-admin-bar-my-account";
    public static final String XPATH_LOGOUT = "Log Out";

    //*[@id="wp-admin-bar-my-account"]/a
    public AdminPage(WebDriver driver) {

        super(driver);
    }

    public void logOut() {

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.id(XPATH_USER));
        action.moveToElement(we).sendKeys("\t").build().perform();
        webWait(By.linkText(XPATH_LOGOUT));
        driver.findElement(By.linkText(XPATH_LOGOUT)).click();
    }

}
