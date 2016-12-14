package pageobject;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Administrator on 2016-12-13.
 */
public class BlogPage extends Page {

    public static final org.openqa.selenium.By POSTS_TITLE = By.xpath("//*[@id=\"content\"]/*/header/h1/a");

    public BlogPage(WebDriver driver) {
        super(driver);
        open("http://streser.nazwa.pl/szkolenia/");
    }

    public void verifyPostTitle(String title) {
        List<WebElement> list = driver.findElements(POSTS_TITLE);
        Assert.assertEquals(list.get(0).getText(),title.toUpperCase());
    }
}
