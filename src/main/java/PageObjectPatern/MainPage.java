package PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public class MainPage extends AdminPage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage goToNewPost() {
        click(By.linkText("Posts"));
        click(By.linkText("Add New"));
        return new AddNewPostPage(driver);
    }

    public PostPage MoveToPostPage() {
        click(By.linkText("Posts"));
        return new PostPage(driver);
    }


}
