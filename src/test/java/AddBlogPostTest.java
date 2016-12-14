
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddBlogPostTest extends Scenario{

    @Test
    public void shouldAddNewPost() {
        LoginPage lp = new LoginPage(driver);
        MainPage ap = lp.logIn();
        AddNewPostPage anp = ap.goToNewPostPage();
        anp.publishNewPost("title_MM", "text");
        anp.logOut();
        HomePage hp = new HomePage(driver);
        hp.openMainPage();
        assertTrue(hp.postIsPublished("title_MM"));

    }

}
