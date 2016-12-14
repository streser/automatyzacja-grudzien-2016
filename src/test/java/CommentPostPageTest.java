import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by Administrator on 2016-12-14.
 */
public class CommentPostPageTest extends ScenarioTest {

    public void shouldAddCommentToThePost(){

        LoginPage lp = new LoginPage(driver);
        lp.openPage();
        lp.tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
        MainPage mp = new MainPage(driver);
        CommentPostPage commentPostPage = new CommentPostPage(driver);
        AddNewPostPage anpp = mp.goToAddPostPage();
        anpp.addNewPost("Ewa", "blablabla");
        Assert.assertTrue(isElementPresent(By.id("message")));
    }
}
