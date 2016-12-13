/**
 * Created by Administrator on 2016-12-13.
 */

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class LoginTests extends SeleniumTest {

    @Test
    public void shouldLoginAndLogout() throws Exception {
        open(baseUrl + "/wp-admin");
        tryLogin(CORRECT_LOGIN, CORRECT_PASSWORD);
        tryLogout();
    }
    @Test
    @Parameters({"CORRECT_LOGIN, INCORRECT_PASSWORD", "INCORRECT_LOGIN, CORRECT_PASSWORD", "INCORRECT_LOGIN, INCORRECT_PASSWORD"})
    public void shouldNotLogin(String login, String password) throws Exception {
        open(baseUrl + "/wp-admin");
        tryLogin(login, password);
        check(LOGIN_ERROR_MESSAGE);
    }

}

