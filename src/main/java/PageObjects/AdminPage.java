package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage openAddNewPostPage() {
        return new AddNewPostPage(driver);
    }
}
