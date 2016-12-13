import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MysFirstSeleniumTest extends Scenario {

    @Test
    public void testMysFirstSelenium() throws Exception {
        // given
        openLoginPage();
        //when
        login();
        // then
        assertTrue(isElementPresent(By.linkText("Twój profil")));

        wyloguj();
    }


}
