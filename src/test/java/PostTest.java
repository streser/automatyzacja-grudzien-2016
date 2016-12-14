import org.junit.Test;
import pageObjectPattern.AddNewPostPage;
import pageObjectPattern.AdminPage;
import pageObjectPattern.HomePage;
import pageObjectPattern.LoginPage;

import static org.junit.Assert.assertTrue;


public class PostTest extends Scenario{

    @Test

    public void shouldBeLogIn(){
        LoginPage lp = new LoginPage(driver);
        AdminPage ap = lp.login("notsosimplepass123", "Warsztatautomatyzacja");
        AddNewPostPage anp = ap.goToAddNewPostPage();
        anp.publishNewPost("title", "text");
        anp.LogOut();
        HomePage hp = new HomePage(driver);
        hp.open();
        assertTrue(hp.PostIsPublished("title"));
    }
}
