package PageObjectPattern;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage goToNewPostPage() {
        return new AddNewPostPage(driver);
    }
}
