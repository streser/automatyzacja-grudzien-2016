import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.Parameters;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class shouldBeAbleToLogin extends selleniumBaseScenario {

    @Test
    public void shouldBeAbleToLogIn() throws Exception {
        openPageUrl("/wp-admin/");
        tryLogin("Warsztatautomatyzacja", "notsosimplepass123");
        assertTrue(isElementPresent(By.cssSelector("h1")));
        tryLogOut();
    }

    @Test
    @Parameters({
            "Warsztatautomatyzacja, asasas",
            "asasas, notsosimplepass123",
            "asasas, asasas",
            ", notsosimplepass123",
            "Warsztatautomatyzacja, ",
            ", "
    })
    public void shouldntAbleToLogInFalseCredentials(String login, String password) throws Exception {
        openPageUrl("/wp-admin/");
        tryLogin(login, password);
        assertTrue(isElementPresent(By.cssSelector("#login_error > strong:nth-child(1)")));
    }


}
