package PageObjectPattern;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class HomePage extends Page{
    public HomePage(WebDriver driver) {
        super(driver);

    }


    public boolean postIsPublished(String title) {
        return false;
    }
}
