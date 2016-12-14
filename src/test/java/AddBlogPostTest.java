import org.junit.Test;
import pageobject.*;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddBlogPostTest extends SeleniumTest {

    private static final String CORRECT_LOGIN = "warsztatautomatyzacja";
    private static final String CORRECT_PASSWORD = "notsosimplepass123";
    public static final String TITLE = "title";
    public static final String TEXT = "text";

    @Test
    public void should() {
        LoginPage lp = new LoginPage(driver);
        MainAdminPage ap = lp.login(CORRECT_LOGIN,CORRECT_PASSWORD);
        PostsPage pp = ap.goToPostPage();
        pp.addNewPost(TITLE, TEXT);
        pp.logOut();
        BlogPage bp = new BlogPage(driver);
        bp.verifyPostTitle(TITLE);
    }
}
