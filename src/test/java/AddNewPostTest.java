

import org.junit.*;

import pageObjectPattern.*;

import static junit.framework.TestCase.assertTrue;


/**
 * Created by Administrator on 2016-12-13.
 */
public class AddNewPostTest extends Scenario{

    @Test
    public void shouldAddNewPost() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.logInToBlog(USERNAME, PASSWORD);
        PostPage postPage = mainPage.goToPostsPage();
        NewPostPage newPostPage = postPage.goToAdddNewPostPage();
        EditPostPage editPostPage = postPage.publishNewPost("title", "body");
        mainPage = editPostPage.isPostPublished();
        mainPage.logOut();
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        assertTrue(homePage.isPostPublished());





    }




}
