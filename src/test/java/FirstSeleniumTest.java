import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertTrue;

public class FirstSeleniumTest extends BaseTest {

    private By loginField = By.id("user_login");
    private By passField = By.id("user_pass");
    private By loginButton = By.id("wp-submit");
    private By accountButton = By.cssSelector("img.avatar.avatar-32");
    private By signOutButton = By.cssSelector("button.ab-sign-out");
    private By someButtonOnSignOutPage = By.cssSelector("button.menu-toggle.x");

    private String login = "warsztatautomatyzacja";
    private String pass = "notsosimplepass123";

    @Test
    public void shouldBeAbleToLoginWithCorrectCredentials() {
        logIn();
        assertTrue(isElementPresent(accountButton));
        signOut();
        assertTrue(isElementPresent(someButtonOnSignOutPage));
    }

    private void tryLogIn(String username, String pass) {
        insertText(loginField, username);
        insertText(passField, pass);
        click(loginButton);
    }

    private void logIn() {
        tryLogIn(login, pass);
    }

    private void signOut() {
        click(accountButton);
        click(signOutButton);
    }

}
