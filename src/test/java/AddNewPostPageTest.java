import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.linkText;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddNewPostPageTest extends ScenarioTest {

    @Test
    public void shouldAddNewPost() {
        LoginPage lp = new LoginPage(driver);
        lp.openPage();
        lp.tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
        MainPage mp = new MainPage(driver);
        AddNewPostPage anpp = mp.goToAddPostPage();
        anpp.addNewPost("Ewa", "blablabla");
        Assert.assertTrue(isElementPresent(By.id("message")));
    }
}
