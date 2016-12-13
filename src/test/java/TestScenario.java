import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;


public class TestScenario {
    public static final By USER_ICON = By.cssSelector("img.avatar.avatar-32");
    public static final String CORRECT_LOGIN = "Warsztatautomatyzacja";
    public static final String CORRECT_PASSWORD = "notsosimplepass123";
    public static final String LOGIN_PAGE_PATH = "/wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1";
    protected WebDriver driver;
    protected String baseUrl;
    //    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
//        driver = new FirefoxDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        WebDriverWait wait = new WebDriverWait(driver, 10);  //czekaj aż jakiś warunek będzie prawdą
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LOGIN_ERROR")));
    }

    public void open(String baseUrl) {
       driver.get(baseUrl);
    }

    protected void tryLogOut() {
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.cssSelector("button.ab-sign-out")).click();
    }

    protected void tryLogIn(String login, String password) {
        insertTekst(By.id("user_login"), login);
        insertTekst(By.id("user_pass"), password);
        driver.findElement(By.id("wp-submit")).click();
    }

    private void insertTekst(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    @After
    public void tearDown() throws Exception {

        driver.close();
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
