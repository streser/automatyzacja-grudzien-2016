/**
 * Created by Administrator on 2016-12-13.
 */

import org.junit.Test;

public class LoginTests extends SeleniumTest {

    @Test
    public void shouldLoginAndLogout() throws Exception {
        open(baseUrl + "/wp-admin");
        tryLogin(CORRECT_LOGIN, CORRECT_PASSWORD);
        tryLogout();
    }
    @Test
    public void shouldNotLogin() throws Exception {
        open(baseUrl + "/wp-admin");
        tryLogin(INCORRECT_LOGIN, INCORRECT_PASSWORD);
        check(LOGIN_ERROR_MESSAGE);
    }

}

