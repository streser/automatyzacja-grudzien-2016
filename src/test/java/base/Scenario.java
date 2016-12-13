package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-12-13.
 */
public class Scenario {

    protected final By ACCOUNT_ICON = By.cssSelector("img.avatar.avatar-32");
    protected final By SOME_BUTTON_ON_SIGN_OUT_PAGE = By.cssSelector("button.menu-toggle.x");
    protected final By LOGIN_ERROR_MESSAGE = By.id("login_error");
    protected final String CORRECT_LOGIN = "warsztatautomatyzacja";
    protected final String CORRECT_PASSWORD = "notsosimplepass123";
    protected final String INCORRECT_PASSWORD = "dupa123";
    protected final String BASE_URL = "http://streser.nazwa.pl/szkolenia/wp-login.php";
    private final By SIGN_OUT_BUTTON = By.cssSelector("button.ab-sign-out");

    protected WebDriver driver;



    @Before
    public void setUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:/workspace/testautomation/src/main/resources/chromedriver.exe");
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
