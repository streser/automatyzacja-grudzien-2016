
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-12-13.
 */
public class BlogPostTest extends Scenario{

    @Test
    public void shouldAddNewPost() {
        UUID randomUUID = UUID.randomUUID();
        String randomString = randomUUID.toString();

        LoginPage lp = new LoginPage(driver);
        MainPage ap = lp.logIn();
        AddNewPostPage anp = ap.goToNewPostPage();
        anp.publishNewPost(randomString, "text");
        anp.logOut();
        HomePage hp = new HomePage(driver);
        hp.openMainPage();
        assertTrue(hp.postIsPublished(randomString));

    }

    @Test
    public void shouldAddCommentToPost(){
        LoginPage lp = new LoginPage(driver);
        MainPage mp = lp.logIn();
        PostsPage psp = mp.goToPostsPage();
        psp.findPost("title");
        ViewPostPage vpp= new ViewPostPage(driver);
        vpp.addComment("comment");
        //add assert
        vpp.logOut();

    }

}
