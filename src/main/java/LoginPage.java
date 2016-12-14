import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends AdminPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage logIn(String warsztatautomatyzacja, String notsosimplepass123) {
        openPageUrl("/wp-admin/");
        tryLogin(warsztatautomatyzacja, notsosimplepass123);
        return new MainPage(driver);
    }

    protected void tryLogin(String login, String password) {
        insertText(By.id("user_login"), login);
        insertText(By.id("user_pass"), password);
        clickElement(By.id("wp-submit"));
    }
}
