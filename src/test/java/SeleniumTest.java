import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class SeleniumTest {

    public static final By USER_ICON = By.cssSelector("img.avatar.avatar-32");
    public static final By LOGOUT_BUTTON = By.cssSelector("button.ab-sign-out");
    public static final By SUBMIT_BUTTON = By.id("wp-submit");
    public static final By PASSWORD_FIELD = By.id("user_pass");
    public static final By USER_LOGIN = By.id("user_login");
    public static final String CORRECT_LOGIN = "warsztatautomatyzacja";
    public static final String CORRECT_PASSWORD = "notsosimplepass123";

    protected WebDriver driver;
    protected String baseUrl;

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        baseUrl = "https://szkolenieautoamatyzacjatech.wordpress.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/wp-admin");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    protected void insertText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    protected void checkAndClick(By by) {
        assertTrue(isElementPresent(by));
        driver.findElement(by).click();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void tryLogin(String login, String password) {
        insertText(USER_LOGIN, login);
        insertText(PASSWORD_FIELD, password);
        checkAndClick(SUBMIT_BUTTON);
    }

    protected void tryLogout() {
        checkAndClick(USER_ICON);
        checkAndClick(LOGOUT_BUTTON);
    }
}
