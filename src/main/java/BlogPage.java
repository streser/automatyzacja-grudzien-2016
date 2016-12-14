import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by User on 13-Dec-16.
 */
public class BlogPage extends Page {

    private static final By LINK_BUTTON = By.cssSelector("#backtoblog > a:nth-child(1)");

    public BlogPage(WebDriver driver) {
        super(driver);
    }



    public boolean isPostPublished(String title) {
/*
        List<WebElement> titles = driver.findElements(By.cssSelector("h1#entry-title > a"));
        List<String> titlesString = new ArrayList<String>();
        for (WebElement t : titles) {
            titlesString.add(t.getText());
        }

        assertTrue(titlesString.contains(title));
        */
        return driver.getPageSource().contains(title);
    }

    public LoginPage LeaveComment(String s, String title) {
        driver.findElement(By.linkText(title)).click();

        driver.findElement(By.id("author")).sendKeys("author");
        driver.findElement(By.id("email")).sendKeys("email");
        driver.findElement(By.id("url")).sendKeys("email");
        driver.findElement(By.id("comment")).sendKeys(s);
        driver.findElement(By.cssSelector("#submit")).click();

        driver.findElement(By.cssSelector("#meta-2 > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();

        return new LoginPage(driver);


    }
}

