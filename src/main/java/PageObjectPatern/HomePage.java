package PageObjectPatern;

import org.openqa.selenium.WebDriver;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public class HomePage extends AdminPage{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public boolean iSPostPublishPost(String tytul) {
return driver.getPageSource().contains(tytul);
    }

    public void logOut(){

    }
}
