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

/**
 * Created by Administrator on 2016-12-13.
 */
public class TestScenario {
    public static final By LOGOUT_BUTTON = By.cssSelector("button.ab-sign-out");
    public static final String CORRECT_LOGIN = "Warsztatautomatyzacja";
    public static final String CORRECT_PASS = "notsosimplepass123";
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver(); z Firefoxem jest problem, lepiej używać Chrome
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies(); //do usuwania cookies, żeby nie blokowało strony jak za dużo razy niepoprawnie się zalogujemy
        baseUrl = "https://szkolenieautoamatyzacjatech.wordpress.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //jeśli strona się przeładuje, poczekaj 30 sec

        // Czeka na pojawienie się jakiegoś elementu na stronie:
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_error")));
    }

    protected void tryLogIn(String login, String pass) {
        insertText(By.id("user_login"), login);
        insertText(By.id("user_pass"), pass);
        driver.findElement(By.id("wp-submit")).click();
    }

    protected void open() {
        driver.get(baseUrl + "wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1");
    }

    protected void tryLogOut() {
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.cssSelector("button.ab-sign-out")).click();
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

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
