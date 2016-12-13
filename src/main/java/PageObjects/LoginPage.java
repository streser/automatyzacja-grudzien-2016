package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public AdminPage logIn() {
        return new AdminPage(driver);
    }
}
