package PageObjects;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-12-13.
 */
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyPublishedPost(String title) {
        assertTrue(false);
    }
}
