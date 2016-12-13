import java.util.concurrent.TimeUnit;

import junitparams.Parameters;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MySeleniumTest extends TestScenario {




    @Test
    public void LoginTest() throws Exception {
        driver.get(baseUrl + "wp-login.php");
        tryLogIn();
        assertTrue(isElementPresent(By.cssSelector("img.avatar.avatar-32")));
        tryLogOut();
    }
    //Test na negatywne logowanie

    //@Test
   // public void shouldNotLogin() throws Exception {
       // driver.get(baseUrl + "/wp-login.php");
        //tryLogIn();
       // assertTrue(isElementPresent(By.linkText("text"))); //Do poprawy!!!
    //}
}
