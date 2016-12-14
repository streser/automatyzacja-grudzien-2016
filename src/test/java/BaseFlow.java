import org.openqa.selenium.By;

/**
 * Created by Administrator on 2016-12-13.
 */
public class BaseFlow extends Scenario {

    private String login_ID = "user_login";
    private String pasword_ID = "user_pass";

    public void login() {
        insertTxt(By.id(login_ID), "Warsztatautomatyzacja");
        insertTxt(By.id(pasword_ID), "notsosimplepass123");
        click(By.id("wp-submit"));
    }

    public void login(String login, String password) {
        waitForElement(By.id(login_ID));
        insertTxt(By.id(login_ID), login);
        waitForElement(By.id(pasword_ID));
        insertTxt(By.id(pasword_ID), password);
        waitForElement(By.id(pasword_ID));
        click(By.id("wp-submit"));
    }
}
