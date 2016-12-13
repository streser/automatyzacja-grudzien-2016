package PageObjectPatern;

import org.openqa.selenium.WebDriver;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public class HomePage extends Page{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void postPublishPost(String title) {
    }

    public boolean iSPostPublishPost(String tytul) {
        return true;
    }
}
