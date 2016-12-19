package PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Pawel_D on 2016-12-14.
 */
public class PostPage extends AdminPage{
    public PostPage(WebDriver driver) {
        super(driver);
    }

    public void publishNewComment(String name, String email, String comment) {
        insertTekst(By.id("author"), name);
        insertTekst(By.id("email"), email);
        insertTekst(By.id("comment"), comment);
        click(By.name("submit"));

    }
    public SinglePostPage zMoveToChosenPost(String post){
//        driver.getPageSource().contains(post);
        driver.findElement(By.xpath("posts-filter"));
        click(By.linkText(post));
        return new SinglePostPage();
    }

}
