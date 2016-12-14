import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends Page {


    public  LoginPage(WebDriver driver) {
        super(driver);}


    public MainPage tryLogIn(String login, String password) {
        insertText(By.id("user_login"), login);
        insertText(By.id("user_pass"), password);
        driver.findElement(By.id("rememberme")).click();
        driver.findElement(By.id("wp-submit")).click();
        return new MainPage(driver);    }


}

