package myOwnProject;

import PageObjectPattern.AddNewPostPage;
import PageObjectPattern.AdminPage;
import PageObjectPattern.HomePage;
import PageObjectPattern.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-12-13.
 */
public class PostTest {

    private WebDriver driver;

    @Test
    public void shouldOpenAndLogon() {
        LoginPage lp = new LoginPage(driver);

        AdminPage ap = lp.login();

        AddNewPostPage amp = ap.goTonewPostPage();

        amp.publischNewPost("Title", "TrescPostu");
        amp.logout();

        HomePage hp = new HomePage(driver);
        assertTrue(hp.postIsPublished("title"));

    }
}

