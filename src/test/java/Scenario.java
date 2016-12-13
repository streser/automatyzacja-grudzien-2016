import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-12-13.
 */
public class Scenario {
    protected WebDriver driver;
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

    protected void openSite() {
        driver.get(baseUrl + "/wp-admin");
    }


    protected void trySignOut() {
        clickButton(By.cssSelector("img.avatar.avatar-32"));
        clickButton(By.cssSelector("button.ab-sign-out"));
    }

    protected void tryLogIn(String login, String password) {
        insertText(By.id("user_login"), login);
        insertText(By.id("user_pass"), password);
        clickButton(By.id("wp-submit"));
    }

    private void clickButton(By by) {
        driver.findElement(by).click();
    }

    private void insertText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
