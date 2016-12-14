import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-12-13.
 */

//klasa Page jest klasą abstrakcyjną
public abstract class Page {

    protected final WebDriver driver;


    public Page(WebDriver driver) {
        this.driver = driver;
    }


    protected void insertText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);

    }

    //    protected void openMainPage() {
//        driver.get(BASE_URL);       // + "wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1"
//    }
    public LoginPage logOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("wp-admin-bar-my-account"))).build().perform();
        action.moveToElement(driver.findElement(By.linkText("Log Out"))).click().build().perform();
        return new LoginPage(driver);

    }



    public void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

