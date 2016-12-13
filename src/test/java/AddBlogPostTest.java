import org.junit.Test;

public class AddBlogPostTest extends TestScenario {

  @Test
  public void shouldAddNewPost() throws InterruptedException{
          LoginPage lp = new LoginPage(driver);
          AdminPage ap = lp.logIn();
          AddNewPostPage anp = ap.goToNewPostPage();
          anp.publishNewPost("title", "text");
          anp.LogOut();
          PostPage pp = new PostPage(driver);
          pp.findPost("title");

        }
}
