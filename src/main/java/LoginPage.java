import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends Page {

    //konstruktor z paramerem
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //metoda logIn() - otwiera nowa strone MainPage
    public MainPage logIn() {

        tryLogIn(CORRECT_LOGIN,CORRECT_PASS);
        return new MainPage(driver);
    }

}