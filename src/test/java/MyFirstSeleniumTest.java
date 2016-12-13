import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Created by Administrator on 2016-12-13.
 */

@RunWith(JUnitParamsRunner.class)

public class MyFirstSeleniumTest extends Scenario {

    @Test
    public void shouldBePossibleToLogIn() throws Exception {
        open();
        tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
        assertTrue(isElementPresent(WRITE_BUTTON));
        tryLogOut();
    }

    @Test
    // Dodaję nowy test na błędne logowanie
    //metodą ze stałymi INCORRECT_LOGIN itd
    public void shouldNotBePossibleToLogIn() {
        open();
        tryLogIn(INCORRECT_LOGIN, INCORRECT_PASSWORD);
        assertTrue(isElementPresent(By.id("login_error")));
    }

    @Test
    //metodą z parametrami
    //można by było też zrobić metodą z parametrami gdzie parametrami będzie stała a nie zmienna string - ale trzeba doczytać jak

    @Parameters({"zlyLogin, zleHaslo"})

    public void shouldNotBePossibleToLogInParam(String login, String haslo) {
        open();
        tryLogIn(login, haslo);
        assertTrue(isElementPresent(By.id("login_error"))); //to wzieliśmy z P-myszy klikając na element na stronie i dodając do Selenium IDE
        //można też przez driver.find element . metoda isDisplayed

    }


}
