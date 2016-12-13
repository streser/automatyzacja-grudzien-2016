package PageObjectPattern;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login() {
        return new MainPage(driver);
    }
}
