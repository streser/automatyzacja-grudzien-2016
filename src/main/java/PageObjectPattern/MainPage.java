package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class MainPage extends AdminPage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage goToNewPostPage() {
        clickButton(By.linkText("Posts"));
        clickButton(By.linkText("Add New"));
        return new AddNewPostPage(driver);
    }
}
