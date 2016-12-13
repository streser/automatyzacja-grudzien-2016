import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Created by Administrator on 2016-12-13.
 */
public class MyFirstSeleniumTest extends Scenario {

    @Test
    public void shouldBePossibleToLogIn() throws Exception {
        open();
        tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
        assertTrue(isElementPresent(WRITE_BUTTON));
        tryLogOut();
    }

}
