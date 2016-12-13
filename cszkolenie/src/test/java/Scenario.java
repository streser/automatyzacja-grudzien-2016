import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-12-13.
 */
public class Scenario {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximalized");

        //  driver = new FirefoxDriver();
        driver = new ChromeDriver(chromeOptions);


        baseUrl = "https://szkolenieautoamatyzacjatech.wordpress.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected void openLoginPage() {
        driver.get(baseUrl + "/wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1");
    }

    protected void wyloguj() {
        klik(By.cssSelector("img.avatar.avatar-32"));
        klik(By.cssSelector("button.ab-sign-out"));
    }

    protected void login() {
        insertTekst(By.id("user_login"), "warsztatautomatyzacja");
        insertTekst(By.id("user_pass"), "notsosimplepass123");
        klik(By.id("wp-submit"));
    }

    private void klik(By by) {
        driver.findElement(by).click();
    }

    private void insertTekst(By by, String tekst) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(tekst);
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
