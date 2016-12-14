import java.util.concurrent.TimeUnit;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


//@RunWith(JUnitParamsRunner.class)

public class MySeleniumTest extends TestScenario {

    @Test
    public void LoginTest() throws Exception {
        driver.get(baseUrl + "wp-login.php");
        tryLogIn();
        //assertTrue(isElementPresent(By.cssSelector("img.avatar.avatar-32")));
        assertTrue(isElementPresent(By.xpath("//img[contains(@src,'http://1.gravatar.com/avatar/3d0edd1f6873a830067ba4cd7fa599c4?s=26&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D26&r=G')]")));
        //tryLogOut();
    }
    //Test na negatywne logowanie

//    @Test
//    @Parameters({"Warsztatautomatyzacja, notsosimplepass123"})
//    public void shouldBeFailedLogin(String login, String passwords)throws Exception{
//        driver.get(baseUrl + "wp-login.php");
//        tryLogIn();
//        assertTrue(isElementPresent(By.id("login_error")));

//    }
}
