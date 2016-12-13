package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class PostsPage extends Page {


    public PostsPage(WebDriver driver) {
        super(driver);
    }

    public void addNewPost(String title, String text) {
        checkAndClick(By.cssSelector("#wpbody-content > div.wrap > h2 > a"));
        insertText(By.id("title"),"Title");
        checkAndClick(By.id("publish"));
    }



    public BlogPage goToBlogPage() {
        return null;
    }

}
