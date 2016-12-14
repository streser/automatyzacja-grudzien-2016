import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class Page {


    public WebDriver driver;
    public static final By USER_ICON = By.cssSelector("img.avatar.avatar-32");
    public static final By LOGOUT_ICON = By.cssSelector("button.ab-sign-out");


    public Page(WebDriver driver)
    {
        this.driver = driver;
    }

    public void openPage(){
        driver.get("https://szkolenieautoamatyzacjatech.wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1");
    }


    public void insertText(By by, String s) {

        waitForElement(by);
        driver.findElement(by).clear();
        ;driver.findElement(by).isEnabled();
        driver.findElement(by).sendKeys(s);
    }


    public void waitForElement(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void tryLogOut() {
        driver.findElement(USER_ICON).click();
        driver.findElement(LOGOUT_ICON).click();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}
