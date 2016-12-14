import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.openqa.selenium.*;



/**
 * Created by Administrator on 2016-12-13.
 */
@RunWith(JUnitParamsRunner.class)

public class LoginPageTest extends ScenarioTest {


    public static final By INCORRECT_LOGIN_ERROR = By.id("login_error");

    @Test
    public void shouldLogInWithCorrectCredentials() throws Exception {
        //given
        LoginPage lp = new LoginPage(driver);
        lp.openPage();
        //when
        lp.tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
        //than
        assertTrue(lp.isElementPresent(By.cssSelector("h2")));
    }


    @Test
    @Parameters({"EwaPietrus, samplepassword", "jadjf, hfiweuh", " , hfiweuh", " fgdrfghdgf, "})
    public void shouldNotLogInWithIncorrectCredentials(String login, String password) {
        //given
        LoginPage lp = new LoginPage(driver);
        lp.openPage();
        //than
        lp.tryLogIn(login, password);
        //than
        lp.waitForElement(INCORRECT_LOGIN_ERROR);

    }
}


