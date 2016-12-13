import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
@RunWith(JUnitParamsRunner.class)
public class LoginTest extends Scenario {

    @Test
    public void shouldBePossibleToLogInWithCorrectCredentials() throws Exception {
        //GIVEN
        open();
        //WHEN
        tryLogin(CORRECT_LOGIN, CORRECT_PASSWORD);

        //THEN
        assertTrue(isElementPresent(ICON));


        tryLogOut();
    }

    //TODO negative login



    @Test
    @Parameters({"asdasd,asfasq1234a","asfasda123,asfasfa123z",","})
    public void shouldNotBePossibleToLogInWithCorrectCredentials(String login, String password) throws Exception {
        //GIVEN
        open();

        //WHEN
        tryLogin(login, password);

        //THEN

        assertTrue(isElementPresent(By.id("login")));

    }





}
