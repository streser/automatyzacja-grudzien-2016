import org.junit.Test;
import pageObjectPattern.*;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddBlogPostPage extends TestScenario {

    @Test
    public void should(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.logIn (USER_NAME, PASSWORD);

        PostPage postPage = mainPage.goToPostPage();
        AddNewPostPage addNewPost = postPage.goToNewPostPage();
        addNewPost.publishNewPost ("title", "content");
        mainPage.logOut();

        HomePage homePage = new HomePage(driver);
        homePage.open();
 //       assertTrue(homePage.isPostPublished("title"));


    }

   // private void assertTrue(void title) {
   // }
}
