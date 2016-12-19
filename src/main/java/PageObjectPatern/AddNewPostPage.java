package PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public class AddNewPostPage extends AdminPage {

    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public void publishNewPost(String tytul, String text) {


        insertTekst(By.id("title"), tytul);
        click(By.id("content-html"));
        insertTekst(By.id("content"), text);
        click(By.id("publish"));
        webWait(By.id("message"));
    }

}
