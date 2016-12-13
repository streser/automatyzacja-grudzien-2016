/**
 * Created by Administrator on 2016-12-13.
 */

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;


import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyFirstSeleniumTest {



        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
           // driver = new FirefoxDriver();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized", "--disable-application-cache");


            driver = new ChromeDriver(chromeOptions);
            baseUrl = "https://szkolenieautoamatyzacjatech.wordpress.com";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void test1java() throws Exception {
            driver.get(baseUrl + "/wp-admin/");

//            new WebDriverWait(driver, 10).until(ExpectedConditions.)

            Thread.sleep(1000);
            driver.findElement(By.id("user_login")).sendKeys("warsztatautomatyzacja");
            Thread.sleep(100);

            driver.findElement(By.id("user_pass")).sendKeys("notsosimplepass123");
            Thread.sleep(100);
            driver.findElement(By.id("wp-submit")).click();


            assertTrue(isElementPresent(By.cssSelector("img.avatar.avatar-32")));
            driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
            driver.findElement(By.cssSelector("button.ab-sign-out")).click();
            assertTrue(isElementPresent(By.linkText("Read more \"First blog post\"")));
        }

        @After
        public void tearDown() throws Exception {
//            driver.quit();
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


