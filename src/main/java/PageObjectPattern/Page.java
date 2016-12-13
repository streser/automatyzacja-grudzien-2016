package PageObjectPattern;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class Page{
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
