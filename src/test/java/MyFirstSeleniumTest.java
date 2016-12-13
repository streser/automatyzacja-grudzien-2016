

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Administrator on 2016-12-13.
 */
public class MyFirstSeleniumTest {






        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();



        @Before
        public void setUp() throws Exception {

            driver = new ChromeDriver();
            baseUrl = "https://www.szkolenieautoamatyzacjatech.wordpress.com";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }

        @Test
        public void testTe() throws Exception {

            driver.get(baseUrl + "/wp-admin/");

            driver.findElement(By.id("user_login")).sendKeys("warsztatautomatyzacja");
            driver.findElement(By.id("user_pass")).clear();
            driver.findElement(By.id("user_pass")).sendKeys("notsosimplepass123");

            driver.findElement(By.id("wp-submit")).click();
            assertTrue(isElementPresent(By.cssSelector("img.avatar.avatar-32")));
            driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
            driver.findElement(By.cssSelector("button.ab-sign-out")).click();
            driver.findElement(By.cssSelector("button.menu-toggle.x")).click();
            driver.findElement(By.xpath("//header[@id='masthead']/button")).click();
            assertTrue(isElementPresent(By.linkText("Read more \"First blog post\"")));
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
