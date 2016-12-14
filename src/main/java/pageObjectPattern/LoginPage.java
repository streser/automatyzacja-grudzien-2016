package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super (driver);
    }

    public AdminPage login(String password, String login) {


        InsertText(By.id("user_login"), login);
        InsertText(By.id("user_pass"), password);
        driver.findElement(By.id("wp-submit")).click();
        return new AdminPage(driver);
    }
}
