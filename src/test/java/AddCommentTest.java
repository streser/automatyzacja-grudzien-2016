import org.junit.Assert;
import org.junit.Test;
import pageobject.BlogPage;
import pageobject.LoginPage;
import pageobject.MainAdminPage;
import pageobject.PostDetailsPage;

/**
 * Created by Administrator on 2016-12-14.
 */
public class AddCommentTest extends SeleniumTest {

    private static final String CORRECT_LOGIN = "warsztatautomatyzacja";
    private static final String CORRECT_PASSWORD = "notsosimplepass123";
    public static final String TEXT = "comment";

    @Test
    public void should() {
        LoginPage lp = new LoginPage(driver);
        MainAdminPage ap = lp.login(CORRECT_LOGIN,CORRECT_PASSWORD);
        BlogPage bp = new BlogPage(driver);
        PostDetailsPage pdp = bp.goToPost(0);
        pdp.addComment(TEXT);
        Assert.assertTrue(pdp.commentHasText(1,TEXT));
    }

}
