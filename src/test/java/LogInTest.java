import java.util.concurrent.TimeUnit;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Administrator on 2016-12-13.
 */
@RunWith(JUnitParamsRunner.class)
public class LogInTest extends TestScenario {

    @Test
    public void shouldLogIn() throws Exception {
        //GIVEN
        open();
        //WHEN
        tryLogIn(CORRECT_LOGIN, CORRECT_PASS);
        //THEN
        assertTrue(isElementPresent(LOGOUT_BUTTON));
        tryLogOut();
    }

    @Test
    @Parameters({"LogIn,Pass","CORRECT_LOGIN,Password","LogIn,CORRECT_PASS"})
    public void shouldNotLogIn(String l, String p) throws Exception {
        //GIVEN
        open();
        //WHEN
        tryLogIn(l, p);
        //THEN
        assertTrue(isElementPresent(By.id("login_error")));

    }

    //    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }

//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }
}


