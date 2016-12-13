import org.junit.Test;
import pageobject.*;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddBlogPostTest extends SeleniumTest {

    public static final String CORRECT_LOGIN = "warsztatautomatyzacja";
    public static final String CORRECT_PASSWORD = "notsosimplepass123";

    @Test
    public void should() {
        LoginPage lp = new LoginPage(driver);
        AdminPage ap = lp.login(CORRECT_LOGIN,CORRECT_PASSWORD);
        PostsPage pp = ap.goToPostPage();
        pp.addNewPost("title", "text");
        pp.logOut();
        BlogPage bp = new BlogPage(driver);
        bp.verifyPostTitle("title");
    }
}
