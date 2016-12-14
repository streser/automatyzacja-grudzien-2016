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
}

