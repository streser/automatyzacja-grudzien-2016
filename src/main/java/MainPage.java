import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-12-13.
 */
public class MainPage extends Page{

    //konstruktor z parametrem
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //metoda goToNewPostPage() - otwiera nową strone AddNewPostPage
    public AddNewPostPage goToNewPostPage() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.id("menu-posts")).click();
        waitFor(By.linkText("Add New"));
        driver.findElement(By.linkText("Add New")).click();
        return new AddNewPostPage(driver);
    }


    public PostsPage goToPostsPage() {
        return new PostsPage(driver);
    }
}
