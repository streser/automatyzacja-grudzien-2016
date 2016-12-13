import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;


import org.junit.*;
import org.openqa.selenium.By;

import static org.junit.Assert.*;
@RunWith(JUnitParamsRunner.class)



public class MyFirstSeleniumTest extends Scenario {
    @Test
    public void testSELENIUMIDE() throws Exception {
        openWebsite();
        tryLogin("Warsztatautomatyzacja", "notsosimplepass123");
        //assertEquals("Kokpit ‹ Site Title — WordPress", driver.getTitle());
        logout("button.ab-sign-out");
    }



    @Test
    @Parameters({"Warsztatautomatyzacja, notsosimplepass123",
            "Warsztatautomatyzacja1, notsosimplepass123",
            "Warsztatautomatyzacja2, notsosimplepass1234"})
    public void shouldBeFailedNegativeLogin(String login, String passwords)throws Exception{
        openWebsite();
        tryLogin(login, passwords);
        assertTrue(isElementPresent(By.id("login_error")));

    }


}
