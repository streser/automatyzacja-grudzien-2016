

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
        EditPostPage editPostPage = newPostPage.publishNewPost("Jasintitle", "Jasinbody");
        assertTrue(editPostPage.getMeassge().contains("Post published"));
        mainPage.logOut();
        HomePage homePage = loginPage.pressBackToBlogHyperlink();
        assertTrue(homePage.isPostPublished("Jasintitle"));
        ExistingPostPage existingPostPage = homePage.goToPostByTitle("Jasintitle");
        existingPostPage.addComment("Jasin Name","jasin@pl.pl","commentJasin");
        assertTrue(existingPostPage.isCommentAdded("commentJasin"));
        existingPostPage.goToLogInPage();
        loginPage.logInToBlog(USERNAME, PASSWORD);
        CommentsPage commentsPage = mainPage.goToCommentsPage();
        commentsPage.approveCommentByComment("commentJasin");
        mainPage.logOut();
        loginPage.pressBackToBlogHyperlink();
        homePage.goToPostByTitle("Jasintitle");









    }




}
