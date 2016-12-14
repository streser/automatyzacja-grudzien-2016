/**
 * Created by Administrator on 2016-12-13.
 */

import org.openqa.selenium.WebDriver;

public class PostPage extends Page {
    public PostPage(WebDriver driver) {
        super(driver);
        open("http://streser.nazwa.pl/szkolenia/");
    }


    public void findPost(String title) {


    }
}
