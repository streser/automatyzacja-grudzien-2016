import com.thoughtworks.selenium.SeleneseTestBase;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-12-13.
 */
public class ScenarioTest {


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
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        baseUrl = "http://streser.nazwa.pl/szkolenia/wp-login.php";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        if (isElementPresent(USER_ICON)) {
            tryLogOut();
        }
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            SeleneseTestBase.fail(verificationErrorString);
        }
    }
}
