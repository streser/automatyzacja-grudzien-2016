import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddNewPostPage extends Page{
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public void publishNewPost(String s) {
    }

    public LoginPage logOut() {
        return new LoginPage(driver);
    }
}
