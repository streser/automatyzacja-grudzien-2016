import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
        open("http://streser.nazwa.pl/szkolenia/wp-login.php");
    }


    public AdminPage logIn() {
        return null;
    }
}
