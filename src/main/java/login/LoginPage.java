package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends Page {

    private String login_ID = "user_login";
    private String pasword_ID = "user_pass";
    private String buttonLogin_ID = "wp-submit";


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public AdminPage login() {
        waitForElement(By.id(login_ID));
        insertTxt(By.id(login_ID), "Warsztatautomatyzacja");
        waitForElement(By.id(login_ID));
        insertTxt(By.id(pasword_ID), "notsosimplepass123");
        click(By.id(buttonLogin_ID));
        return new AdminPage(driver);

    }
}
