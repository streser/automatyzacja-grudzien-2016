import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class myFirstSeleniumIDEtest extends TestScenario {

    @Test
    public void testSeleniumIDE() throws Exception {

        driver.get(baseUrl + "wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1/");

        tryLogin();
        assertTrue(isElementPresent(By.cssSelector("img.avatar.avatar-32")));
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.cssSelector("button.ab-sign-out")).click();
    }

}


