import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddBlogPostTest {

    private WebDriver driver;

    @Test
    public void  shouldAddPostToBlog(){

        LoginPage lp = new LoginPage(driver);

        //po zalogowaniu się przejdziemy do strony Admin Page, wiec:
        AdminPage ap = lp.logIn();

        //na stronie Admin Page będziemy chcieli dodać nowy post
        AddNewPostPage anp = ap.goToNewPost();

        anp.publishNewPost("Tytuł i Treść postu");

        lp = anp.logOut();

        //na stronieHomePage będą widoczne dodane posty
        BlogsPage hp = new BlogsPage(driver);
        hp.open();
        assertTrue(hp.postIsPublished("Tytuł postu"));


    }

}
