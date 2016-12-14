/**
 * Created by User on 13-Dec-16.
 */
import org.junit.Test;

import java.util.UUID;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddingNewPostTest extends Scenario2{





    @Test
    public void shouldAddNewBlogPage(){

        LoginPage lp = new LoginPage(driver);
        AdminPage ap = lp.logIn();
        NewPostPage npp = ap.goToNewPostPage();
        UUID name = UUID.randomUUID();

        npp.publishNewPage(name.toString(), "body");
        lp = npp.logOut();
        BlogPage bp = lp.GoToBlog();
        bp.isPostPublished(name.toString());
        bp.LeaveComment("Add New Comment", name.toString());
        //ap = lp.logIn();



    }




}
