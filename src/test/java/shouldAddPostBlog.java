import org.junit.After;
import org.junit.Test;

import java.util.UUID;

public class shouldAddPostBlog extends selleniumBaseScenario {
    @Test
    public void shouldAddPostBlog() {
        LoginPage loginpage = new LoginPage(driver);
        MainPage adminpage = loginpage.logIn("Warsztatautomatyzacja", "notsosimplepass123");
        AddNewPost addnewspage = adminpage.goToPostPage();
        String title_post = UUID.randomUUID().toString() + " Title post.";
        String content = UUID.randomUUID().toString() + " Write content nadfgoihadglkna afjbgadmfgnaiodg adfjignadkl.";

        addnewspage.CreatePost(title_post, content);
        addnewspage.publishPost();
        addnewspage.logOut();

        BlogPage homepage = new BlogPage(driver);
        homepage.findPost("title");
    }
    @After
    public void tearDown() throws Exception {
       // driver.quit();
    }
}
