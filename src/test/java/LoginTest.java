import base.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithCorrectCredentials() {
        open(BASE_URL);
        logIn();
        assertTrue(isElementPresent(ACCOUNT_ICON));
        /*signOut();
        assertTrue(isElementPresent(SOME_BUTTON_ON_SIGN_OUT_PAGE));*/
    }

    @Test
    @Parameters(method = "paramsMethod")
    public void shouldNotBeAbleToLoginWithIncorrectCredential(String login, String password) {
        open(BASE_URL);
        tryLogIn(login, password);
        assertTrue(isElementPresent(LOGIN_ERROR_MESSAGE));
    }

    private Object[] paramsMethod() {
        return new Object[]{
                new Object[]{CORRECT_LOGIN, INCORRECT_PASSWORD},
                new Object[]{INCORRECT_PASSWORD, CORRECT_PASSWORD},
                new Object[]{INCORRECT_PASSWORD, INCORRECT_PASSWORD},
        };
    }
}
