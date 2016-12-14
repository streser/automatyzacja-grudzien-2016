import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;


import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-12-13.
 */


@RunWith(JUnitParamsRunner.class)
public class testTest extends TestScenario {


    @Test
    public void testIdea() throws Exception {
        login();
        check(By.xpath("//*[@class='welcome-panel-content']/h3"), "Welcome to WordPress!");
    }


//    @Test
//    @Parameters({"BlednyLogin, notsosimplepass123", "Warsztatautomatyzacja, bledneHaslo", "BlednyLogin, bledneHaslo"})
//    public void negativeLogin_WrongLogin_Test(String login, String password) throws Exception {
//        login(login, password);
//        check(By.xpath("//*[@id='login_error']/strong[1]"), "ERROR");
//    }
}
