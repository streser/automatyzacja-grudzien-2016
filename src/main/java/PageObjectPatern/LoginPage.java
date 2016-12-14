package PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public class LoginPage extends Page {

    private String login;
    private String password;

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public MainPage logIn(String login, String password) {
        insertTekst(By.id("user_login"), login);
        insertTekst(By.id("user_pass"), password);
        driver.findElement(By.id("wp-submit")).click();
        return new MainPage(driver);
    }

}
