

import org.junit.*;

import static org.junit.Assert.*;


public class MyFirstSeleniumtest extends TestScenario {

    @Test
    public void shouldBePossibleToLogInWithCorrectCredentials() throws Exception {
        driver.get(baseUrl + LOGIN_PAGE_PATH);

        tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);

        assertTrue(isElementPresent(USER_ICON));
        tryLogOut();
    }


}
