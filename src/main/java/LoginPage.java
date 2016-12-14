import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends Page {
    protected static final String CORRECT_LOGIN = "Warsztatautomatyzacja";
    protected static final String CORRECT_PASS = "notsosimplepass123";

    //konstruktor z paramerem
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //metoda logIn() - otwiera nowa strone MainPage
    public MainPage logIn() {
        tryLogIn(CORRECT_LOGIN, CORRECT_PASS);
        return new MainPage(driver);
    }

    protected void tryLogIn(String login, String pass) {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitFor(By.id("loginform"));
        insertText(By.id("user_login"), login);
        insertText(By.id("user_pass"), pass);
        driver.findElement(By.id("wp-submit")).click();
    }

}