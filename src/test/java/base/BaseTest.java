package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class BaseTest {

    protected final By LOGIN_FIELD = By.id("user_login");
    protected final By PASSWORD_FIELD = By.id("user_pass");
    protected final By LOGIN_BUTTON = By.id("wp-submit");
    protected final By ACCOUNT_ICON = By.cssSelector("li#wp-admin-bar-my-account");
    protected final By SOME_BUTTON_ON_SIGN_OUT_PAGE = By.cssSelector("button.menu-toggle.x");
    protected final By LOGIN_ERROR_MESSAGE = By.id("login_error");
    protected final String CORRECT_LOGIN = "warsztatautomatyzacja";
    protected final String CORRECT_PASSWORD = "notsosimplepass123";
    protected final String INCORRECT_PASSWORD = "dupa123";
    protected final String BASE_URL = "http://streser.nazwa.pl/szkolenia/wp-login.php";
    private final By SIGN_OUT_BUTTON = By.cssSelector("button.ab-sign-out");

    private WebDriver driver;
    WebDriverWait wait;

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) fail(verificationErrorString);
    }

    @Before
    public void setUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:/workspace/testautomation/src/main/resources/chromedriver.exe");
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    protected void insertText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void open(String url){
        driver.get(url);
    }

    protected void signOut() {
        click(ACCOUNT_ICON);
        click(SIGN_OUT_BUTTON);
    }

    protected void tryLogIn(String username, String pass) {
        insertText(LOGIN_FIELD, username);
        insertText(PASSWORD_FIELD, pass);
        click(LOGIN_BUTTON);
    }

    protected void logIn() {
        tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
    }

    protected void waitForPresent(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
