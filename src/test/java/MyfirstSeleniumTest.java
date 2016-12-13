import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.fail;


public class MyfirstSeleniumTest {private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        ChromeOptions chromeOptions = new ChromeOptions();//uzywamy to zamiast funkcji maximaze -zajmuje mniej czasu
        chromeOptions.addArguments("--start-maximized"); //parametr chromedrivera

        driver = new ChromeDriver(chromeOptions);
        baseUrl = "https://szkolenieautoamatyzacjatech.wordpress.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSeleniumIde2() throws Exception {
        driver.get(baseUrl + "/wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1");
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("Warsztatautomatyzacja");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("notsosimplepass123");
        driver.findElement(By.id("wp-submit")).click();
        assertEquals("Kokpit ‹ Site Title — WordPress", driver.getTitle());
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.cssSelector("button.ab-sign-out")).click();
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


