import PageObjectPatern.AddNewPostPage;
import PageObjectPatern.AdminPage;
import PageObjectPatern.HomePage;
import PageObjectPatern.LoginPage;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public class WriteNewPostTest extends Scenarios {

    @Test
    public void shouldWriteNewPost(){
        LoginPage lp = new LoginPage(driver);
        AdminPage ap = lp.logIn("login","pasword");
        AddNewPostPage adp = ap.goToNewPost();
        adp.publishNewPost("title","text");
        adp.logOut();
        HomePage hp = new HomePage(driver);
        assertTrue(hp.iSPostPublishPost("tytul"));

    }
}
