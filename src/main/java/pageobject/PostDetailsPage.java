package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Administrator on 2016-12-14.
 */
public class PostDetailsPage extends Page {


    public static final By COMMENT_FIELD = By.xpath("//*[@id=\"comment\"]");

    public PostDetailsPage(WebDriver driver) {
        super(driver);
    }


    public void addComment(String text) {
        waitForElement(COMMENT_FIELD);
        insertText(COMMENT_FIELD,text);
        checkAndClick(By.xpath("//*[@id=\"submit\"]"));

    }

    public boolean commentHasText(int i, String text) {
        List<WebElement> list = driver.findElements(By.xpath("//*/div[1]/p"));
        System.out.print(list.get(i).getText());
        return (list.get(i).getText().equals(text));
    }
}
