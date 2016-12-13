import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyFirstSeleniumTest extends Scenario {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Test
    public void testSELENIUMIDE() throws Exception {
        driver.get(baseUrl + "/wp-admin");
        tryLogin("Warsztatautomatyzacja", "notsosimplepass123");
        assertEquals("Kokpit â€ą Site Title â€” WordPress", driver.getTitle());
        logout("button.ab-sign-out");
    }


}
