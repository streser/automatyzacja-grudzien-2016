import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestScenario {
    protected WebDriver driver;
    protected String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        driver = new ChromeDriver(chromeOptions);
        baseUrl = "http://streser.nazwa.pl/szkolenia/";
        //baseUrl = "http://streser.nazwa.pl/szkolenia/";
        //baseUrl = "https://szkolenieautoamatyzacjatech.wordpress.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected void tryLogOut() {
        //driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        //driver.findElement(By.cssSelector("button.ab-sign-out")).click();
        driver.findElement(By.linkText("Log Out")).click();
    }

    protected void tryLogIn() {
        insertText(By.id("user_login"), "Warsztatautomatyzacja");
        insertText(By.id("user_pass"), "notsosimplepass123");
        driver.findElement(By.id("wp-submit")).click();
    }

    private void insertText(By byElement, String text) {
        driver.findElement(byElement).clear();
        driver.findElement(byElement).sendKeys(text);
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
