package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class PostPage extends Page {
    public PostPage(WebDriver driver) {
        super(driver);
    }

    public void clickToGoToAddNewPost(){
        click(By.xpath("//*[@id='wpbody-content']/div[4]/h2/a"));
    }

    public AddNewPostPage goToNewPostPage() {
        clickToGoToAddNewPost();

        return new AddNewPostPage(driver);
    }
}
