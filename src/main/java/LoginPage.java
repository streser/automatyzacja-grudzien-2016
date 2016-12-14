import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

    public static final By SUBMIT_BUTTON = By.id("wp-submit");
    public static final By PASSWORD_FIELD = By.id("user_pass");
    public static final By USERNAME_FIELD = By.id("user_login");


    public LoginPage(WebDriver driver) {
        super(driver);
        open("http://streser.nazwa.pl/szkolenia/wp-login.php");
    }

    /*
    public void logIn(){
        insertText(By.id("user_login"), "Warsztatautomatyzacja");
        insertText(By.id("user_pass"), "notsosimplepass123");
        driver.findElement(By.id("wp-submit")).click();
    }
    */

    public AdminPage logIn(String username, String password) {
        insertText(USERNAME_FIELD, username);
        insertText(PASSWORD_FIELD, password);
        checkAndClick(SUBMIT_BUTTON);
        return new AdminPage(driver);
    }
}
