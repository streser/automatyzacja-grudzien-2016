/**
 * Created by Administrator on 2016-12-13.
 */

import org.junit.Test;

public class MyFirstSeleniumTest extends SeleniumTest {

    @Test
    public void shouldLoginAndLogout() throws Exception {
        tryLogin(CORRECT_LOGIN, CORRECT_PASSWORD);
        tryLogout();
    }
}

