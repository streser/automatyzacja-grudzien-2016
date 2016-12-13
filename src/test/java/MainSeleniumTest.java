import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-12-13.
 */
public class MainSeleniumTest {


    public static final String CORRECT_LOGIN = "warsztatautomatyzacja";
    public static final String CORRECT_PASSWORD = "notsosimplepass123";
    public WebDriver driver;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();
    public static final By USER_ICON = By.cssSelector("img.avatar.avatar-32");
    public static final By LOGOUT_ICON = By.cssSelector("button.ab-sign-out");

    @Before
    public void setUp() throws Exception {
//        driver = new FirefoxDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        baseUrl = "https://szkolenieautoamatyzacjatech.wordpress.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void openPage(){
        driver.get("https://szkolenieautoamatyzacjatech.wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1");
    }
    public void tryLogIn(String login, String password) {
        insertText(By.id("user_login"), login);
        insertText(By.id("user_pass"), password);
        driver.findElement(By.id("rememberme")).click();
        driver.findElement(By.id("wp-submit")).click();
    }

    public void insertText(By by, String s) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(s);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void tryLogOut() {
        driver.findElement(USER_ICON).click();
        driver.findElement(LOGOUT_ICON).click();
    }

    @After
    public void tearDown() throws Exception {
        if(isElementPresent(USER_ICON)){
            tryLogOut();
        }
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
