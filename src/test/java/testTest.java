import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * Created by Administrator on 2016-12-13.
 */
public class testTest {

        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            ChromeOptions chromeOptions =new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            baseUrl = "https://szkolenieautoamatyzacjatech.wordpress.com";
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testIdea() throws Exception {
            driver.get(baseUrl + "/wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1");
            driver.findElement(By.id("user_login")).clear();
            driver.findElement(By.id("user_login")).sendKeys("Warsztatautomatyzacja");
            driver.findElement(By.id("user_pass")).clear();
            driver.findElement(By.id("user_pass")).sendKeys("notsosimplepass123");
            driver.findElement(By.id("wp-submit")).click();
            assertEquals("Witaj na WordPress.com!", driver.findElement(By.cssSelector("h2")).getText());
            driver.findElement(By.xpath("//*[@class='elsewhere-tv']")).click();
            driver.findElement(By.xpath("//*[@class='elsewhere-tv']")).click();
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
