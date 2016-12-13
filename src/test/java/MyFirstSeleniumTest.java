import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MyFirstSeleniumTest extends Scenario {

    @Test
    public void shouldBePossibleToLogInWithCorrectCredentials() throws Exception {
        //GIVEN
        open();
        //WHEN
        tryLogin(CORRECT_LOGIN, CORRECT_PASSWORD);

        //THEN
        assertTrue(isElementPresent(ICON));


        tryLogOut();
    }
}
