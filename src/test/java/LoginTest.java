import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class LoginTest extends TestScenario {

    @Test
    @Parameters({"wrongLogin, wrongPassword", "wrongLogin2, wrongPasswor2", "wrongLogin3, wrongPassword3"})
    public void wrongLogin(String login, String password) {

        driver.get(baseUrl + "wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1/");

        tryLogin(password, login);
        assertTrue(isElementPresent(By.id("login_error")));

        //WebDriver wait = new WebDriver(driver, timeOutInSeconds 10); //czekaj aż jakiś warunek okaże się prawda
        //wait.until (ExpectedCondition.presentOfElemntLocated(By.id("LOGGIN_ERROR")));
    }

    @Test
    public void shouldBeLogIn() throws Exception {

        driver.get(baseUrl + "wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1/");

        tryLogin("notsosimplepass123", "Warsztatautomatyzacja");
        assertTrue(isElementPresent(By.id("welcome-panel")));

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a/img"))).build().perform();
        action.moveToElement(driver.findElement(By.linkText("Log Out"))).click().build().perform();
    }
}