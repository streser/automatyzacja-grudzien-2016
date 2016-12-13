import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-12-13.
 */
public class TestScenario {
    public static final String USER_NAME = "warsztatautomatyzacja";
    public static final String PASSWORD = "notsosimplepass123";
    public static final String BaseUrl = "http://streser.nazwa.pl/szkolenia/wp-login.php";
    public WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        // driver = new FirefoxDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized", "--disable-application-cache");


        driver = new ChromeDriver(chromeOptions);
        baseUrl = BaseUrl;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        open(BaseUrl);
    }

    public void open(String s) {
        driver.get(baseUrl);
    }

    protected void tryLogOut() {
        click(By.cssSelector("#wp-admin-bar-my-account > a > img"));
        click(By.cssSelector("#wp-admin-bar-logout > a"));
    }
    public void assertTrueElementOnDashboard () {
        assertTrue(isElementPresent(By.xpath("//*[@id='menu-dashboard']/a/div[3]")));
    }

    public void assertFalseElementOnDashboard () {
        assertNotEquals(driver.getCurrentUrl(),"http://streser.nazwa.pl/szkolenia/wp-login.php");
    }
    protected void tryLogIn(String user_name, String password) {
        insertText(By.id("user_login"), user_name);

        insertText(By.id("user_pass"), password);

        click(By.id("wp-submit"));
    }

    private void click(By by) {
        driver.findElement(by).click();
    }

    private void insertText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
