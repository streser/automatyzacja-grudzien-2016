package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddNewPostPage extends AdminPage {
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public void publischNewPost(String title, String trescPostu) {
        insertText(By.id("title"), title);
        insertText(By.id("content"), trescPostu);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated((By.id("publish"))));
        clickButton(By.id("publish"));


    }
}
