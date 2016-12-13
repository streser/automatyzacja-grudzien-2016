package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-12-13.
 */
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyPublishedPost(String title) {

        List<WebElement> titles = driver.findElements(By.cssSelector("h1#entry-title > a"));
        List<String> titlesString = new ArrayList<String>();
        for(WebElement t : titles){
            titlesString.add(t.getText());
        }

        assertTrue(titlesString.contains(title));
    }
}
