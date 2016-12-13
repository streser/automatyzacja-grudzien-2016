package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class BasePage {
    protected WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
    }

    public BasePage open(String url) {
        return new BasePage(driver);
    }
}
