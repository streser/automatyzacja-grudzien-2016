package PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public class AddNewPostPage extends Page{
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public void publishNewPost(String title, String text) {
        insertTekst(By.id("title"),"tytul");

    }

    public void logOut() {
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.cssSelector("button.ab-sign-out")).click();
    }
}
