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
    protected static final String CORRECT_LOGIN = "Warsztatautomatyzacja";
    protected static final String CORRECT_PASS = "notsosimplepass123";

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void tryLogIn(String login, String pass) {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitFor(By.id("loginform"));
        insertText(By.id("user_login"), login);
        insertText(By.id("user_pass"), pass);
        driver.findElement(By.id("wp-submit")).click();
    }


    protected void insertText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);

    }

//    protected void openMainPage() {
//        driver.get(BASE_URL);       // + "wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1"
//    }

    public void tryLogOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.id("wp-admin-bar-my-account"));
        action.moveToElement(element).build().perform();
        waitFor(By.linkText("Log Out"));
        driver.findElement(By.linkText("Log Out")).click();

    }

    public void openAddNewPostPage() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.id("menu-posts")).click();
        waitFor(By.linkText("Add New"));
        driver.findElement(By.linkText("Add New")).click();
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

