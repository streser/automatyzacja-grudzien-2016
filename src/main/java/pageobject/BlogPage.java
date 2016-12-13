package pageobject;


import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class BlogPage extends Page {
    
    public BlogPage(WebDriver driver) {
        super(driver);
        open("http://streser.nazwa.pl/szkolenia/");
    }

    public void verifyPostTitle(String title) {

    }
}
