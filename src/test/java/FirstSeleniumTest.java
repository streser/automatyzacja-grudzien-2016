import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertTrue;

public class FirstSeleniumTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithCorrectCredentials() {
        open(BASE_URL);
        logIn();
        assertTrue(isElementPresent(ACCOUNT_ICON));
        signOut();
        assertTrue(isElementPresent(SOME_BUTTON_ON_SIGN_OUT_PAGE));
    }

    @Test
    public void shouldNotBeAbleToLoginWithIncorrectCredentials() {
        open(BASE_URL);
        tryLogIn(CORRECT_LOGIN, INCORRECT_PASSWORD);
        assertTrue(isElementPresent(LOGIN_ERROR_MESSAGE));
    }

    private void tryLogIn(String username, String pass) {
        insertText(LOGIN_FIELD, username);
        insertText(PASSWORD_FIELD, pass);
        click(LOGIN_BUTTON);
    }

    private void logIn() {
        tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
    }

}
