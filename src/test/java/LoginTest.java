import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.openqa.selenium.*;


/**
 * Created by Administrator on 2016-12-13.
 */
@RunWith(JUnitParamsRunner.class)
public class LoginTest extends MainSeleniumTest {

    @Test
    public void shouldLogInWithCorrectCredentials() throws Exception {
        //given
        openPage();
        //when
        tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
        //than
        assertTrue(isElementPresent(By.cssSelector("h2")));
    }

    //TODO napisać negatywny test
//    public void shouldNotLogInWithIncorrectCredentials(){
//        //given
//        openPage();
//        //than
//        @Parameters("EwaPietrus", "samplepassword")
//        tryLogIn(String login, String password);
//

//    }
}


