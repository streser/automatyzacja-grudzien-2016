import org.junit.Test;

im import static junit.framework.TestCase.assertTrue;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddingNewPostTest extends Scenario2{


    @Test
    public void shouldAddNewBlogPage(){

        LoginPage lp = new LoginPage(driver);
        AdminPage ap = lp.logIn();
        NewPostPage npp = ap.goToNewPostPage();
        npp.publishNewPage("title", "body");
        lp = npp.logOut();
        BlogPage bp = lp.GoToBlog();
        bp.open();
        assertTrue(bp.IsPostPublished("title"));

    }




}
