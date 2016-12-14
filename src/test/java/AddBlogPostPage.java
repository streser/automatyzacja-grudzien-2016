import org.junit.Test;
import pageObjectPattern.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddBlogPostPage extends TestScenario {

    @Test
    public void should() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.logIn(USER_NAME, PASSWORD);

        PostPage postPage = mainPage.goToPostPage();
        AddNewPostPage addNewPost = postPage.goToNewPostPage();
        addNewPost.publishNewPost("LKtitle", "LKcontent");
        mainPage.logOut();
        HomePage homePage = loginPage.backToBlog();
        assertTrue(homePage.isPostPublished("LKtitle"));


    }

    // private void assertTrue(void title) {}
}
