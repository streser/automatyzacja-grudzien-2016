import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.fail;


public class MyfirstSeleniumTest extends Scenario {

    @Test
    public void testSeleniumIde2() throws Exception {
        openSite();
        tryLogIn("Warsztatautomatyzacja", "notsosimplepass123");
        assertEquals("Kokpit ‹ Site Title — WordPress", driver.getTitle());
        trySignOut();
    }

}