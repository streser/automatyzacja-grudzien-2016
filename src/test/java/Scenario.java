import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Scenario {
    protected WebDriver driver;
    protected String baseUrl;

    @Before
    public void setUp() throws Exception {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // PARAMETR CHROMEDRIVER
        driver = new ChromeDriver(chromeOptions);
        baseUrl = "https://szkolenieautoamatyzacjatech.wordpress.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected void logout(String selector) {
        clickButton(By.cssSelector(selector));
    }

    protected void tryLogin(String login, String pass) {
        insertText(By.id("user_login"), login);
        insertText(By.id("user_pass"), pass);
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
