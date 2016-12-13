import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Administrator on 2016-12-13.
 */
@RunWith(JUnitParamsRunner.class)

public class LoginTest extends MainSeleniumTest {

    public static final By INCORRECT_LOGIN_ERROR = By.id("login_error");

    @Test
    public void shouldLogInWithCorrectCredentials() throws Exception {
        //given
        openPage();
        //when
        tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
        //than
        assertTrue(isElementPresent(By.cssSelector("h2")));
    }


    @Test
    @Parameters({"EwaPietrus, samplepassword", "jadjf, hfiweuh", " , hfiweuh", " fgdrfghdgf, "})
    public void shouldNotLogInWithIncorrectCredentials(String login, String password) {
        //given
        openPage();
        //than
        tryLogIn(login, password);
        //than
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(INCORRECT_LOGIN_ERROR));


    }
}


