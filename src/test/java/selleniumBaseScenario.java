import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by micha on 13.12.2016.
 */
public class selleniumBaseScenario {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("--start-maximized");

        driver = new ChromeDriver(ChromeOptions);

        driver.manage().deleteAllCookies();
        //baseUrl = "https://szkolenieautoamatyzacjatech.wordpress.com";
        baseUrl = "http://stalma.ch/testautom";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //WebDriverWait wait = new WebDriverWait(10);

    }

    protected void tryLogOut() {
        clickElement(By.cssSelector("img.avatar.avatar-32"));
        clickElement(By.cssSelector("button.ab-sign-out"));
        //clickElement(By.xpath("//*[@id=\"wp-admin-bar-logout\"]/a"));
        //clickElement(By.cssSelector("#wp-admin-bar-logout > a"));
        //clickElement(By.linkText("Wyloguj się"));
        //clickElement(By.xpath("//*[@id=\"wp-admin-bar-logout\"]/a"));
    }

    protected void openPageUrl(String urlPage) {
        driver.get(baseUrl + urlPage);
    }

    protected void tryLogin(String login, String password) {
        insertText(By.id("user_login"), login);
        insertText(By.id("user_pass"), password);
        clickElement(By.id("wp-submit"));
    }

    private void clickElement(By byParameters) {
        driver.findElement(byParameters).click();
    }

    private void insertText(By byElement, String text) {
        driver.findElement(byElement).clear();
        driver.findElement(byElement).sendKeys(text);
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @After
    public void tearDown() throws Exception {
       driver.quit();
    }
}
