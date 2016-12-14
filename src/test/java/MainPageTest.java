import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by Administrator on 2016-12-13.
 */
public class MainPageTest extends ScenarioTest {

    @Test
    public void shouldRedirectToAddNewPost() {
        LoginPage lp = new LoginPage(driver);
        lp.openPage();
        lp.tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
        MainPage mp = new MainPage(driver);
        mp.goToAddPostPage();
        Assert.assertTrue(isElementPresent(By.cssSelector("#wpbody-content > div.wrap > h1")));

    }
}
