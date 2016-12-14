import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Administrator on 2016-12-13.
 */
public class Scenario {

    public WebDriver driver;


    public void openPage(String url) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url + "/wp-login.php");
    }

    public void insertTxt(By by, String s) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(s);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void check(By by, String txt) {
        assertEquals(txt, driver.findElement(by).getText());
    }

    public void closePage() {
        StringBuffer verificationErrors = new StringBuffer();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void waitForElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, ""));
    }

    public void waitForElementIsPresent(By by, String txt) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, txt));
    }

    public void claerCookies(){
        driver.manage().deleteAllCookies();
    }
}
