/**
 * Created by Administrator on 2016-12-14.
 */

import org.openqa.selenium.WebDriver;


public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void open(String url) {
        driver.get(url);
    }


}
