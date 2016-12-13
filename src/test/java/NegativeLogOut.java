import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 2016-12-13.
 */

@RunWith(JUnitParamsRunner.class)
public class NegativeLogOut extends TestScenario {

    @Test
    @Parameters({"asd, AS",
            ",notsosimplepass123",
            "Warsztatautomatyzacja,",
            ","
    })
    public void test2java(String wrongLogIn, String wrongPassword) throws Exception {
        // Given - przygotowanie do testu
        open(BaseUrl + "/wp-admin/");
        // When - logowanie do stronki - mają być zle credantiale
        tryLogIn(wrongLogIn, wrongPassword);
        //Then - asercje czy element jest na dashboardzie
        assertFalseElementOnDashboard();
    }
}


// WebdriverWait wait = new Webdriver (driver, 10);
// wait.until(ExpectedComditions.x);