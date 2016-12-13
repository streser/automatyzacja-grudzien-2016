

import junit.framework.*;
import org.junit.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class LoginTest extends TestScenario {

    @Test
    public void shouldBePossibleToLogInWithCorrectCredentials() throws Exception {
        open("http://streser.nazwa.pl/szkolenia" + LOGIN_PAGE_PATH);

        tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);

        assertTrue(isElementPresent(USER_ICON));
        tryLogOut();
    }
//TODO piszemy test na negatywne logowanie

    @Test
    @Parameters({"incorrectLogin, notsosimplepass123","Warsztatautomatyzacja, incorrectpassword","incorrectLogin, incorrectpassword"})
    public void shouldNotBePossibleToLogInWithCorrectCredentials(String login, String password) throws Exception {
        driver.get(baseUrl + LOGIN_PAGE_PATH);

        tryLogIn(login, password);
//        driver.close();
        Assert.assertFalse(isElementPresent(USER_ICON));
    }
}
