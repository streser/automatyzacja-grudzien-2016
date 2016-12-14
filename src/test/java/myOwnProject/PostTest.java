package myOwnProject;

import PageObjectPattern.AddNewPostPage;
import PageObjectPattern.HomePage;
import PageObjectPattern.LoginPage;
import PageObjectPattern.MainPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class PostTest extends SeleniumBase {
    @Test
    public void shouldOpenAndLogon() {
        LoginPage lp = new LoginPage(driver);

        MainPage mp = lp.login();

        AddNewPostPage amp = mp.goToNewPostPage();

        amp.publischNewPost("Lubie placki", "Lubie wszystkie placki");
        lp = amp.logout();

        HomePage hp = lp.goToHomePage();
        assertTrue(hp.postIsPublished("Lubie placki"));
    }
}


