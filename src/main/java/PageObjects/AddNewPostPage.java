package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddNewPostPage extends BasePage{
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage publishNewPost(String title, String text) {

        return this;
    }

    public LogOutPage logOut() {
        return new LogOutPage(driver);
    }
}
