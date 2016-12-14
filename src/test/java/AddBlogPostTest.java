import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AddBlogPostTest extends TestScenario  {

    public static final String CORRECT_LOGIN = "warsztatautomatyzacja";
    public static final String CORRECT_PASSWORD = "notsosimplepass123";

  @Test
  public void shouldAddNewPost() throws InterruptedException{
          LoginPage lp = new LoginPage(driver);
          AdminPage ap = lp.logIn(CORRECT_LOGIN,CORRECT_PASSWORD);
          //AdminPage ap = lp.logIn();
          AddNewPostPage anp = ap.goToNewPostPage();
          anp.publishNewPost("title", "text");
          anp.logOut();
          PostPage pp = new PostPage(driver);
          pp.findPost("title");
        }
}

