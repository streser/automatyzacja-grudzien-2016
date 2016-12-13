/**
 * Created by Administrator on 2016-12-13.
 */

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class LoginTest extends SeleniumTest {

    @Test
    public void shouldLoginAndLogout() throws Exception {
        open(baseUrl + "/wp-admin");
        tryLogin(CORRECT_LOGIN, CORRECT_PASSWORD);
        tryLogout();
    }

    @Test
    @Parameters( method = "incorrectLogins" )
    public void shouldNotLogin(String login, String password) throws Exception {
        open(baseUrl + "/wp-admin");
        tryLogin(login, password);
        check(LOGIN_ERROR_MESSAGE);
    }

    private List<List<String>> incorrectLogins() {
        return Arrays.asList(
                Arrays.asList(CORRECT_LOGIN, INCORRECT_PASSWORD),
                Arrays.asList(INCORRECT_LOGIN, CORRECT_PASSWORD),
                Arrays.asList(INCORRECT_LOGIN, INCORRECT_PASSWORD)
        );
    }
}

