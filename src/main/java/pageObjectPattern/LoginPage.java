package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName (String user_name){
        waitForElement(By.id("user_login"));
        insertText(By.id("user_login"), user_name);
    }

    public void fillPassword (String password){

        insertText(By.id("user_pass"), password);
    }

    public void clickToLogIn (){

        click(By.id("wp-submit"));
    }

    public MainPage logIn(String userName, String password) {

        fillUserName(userName);
        fillPassword(password);
        clickToLogIn();

        return new MainPage(driver);
    }

    public HomePage backToBlog () throws InterruptedException {
        waitForElement(By.cssSelector("#backtoblog > a"));
        click(By.cssSelector("#backtoblog > a"));
        Thread.sleep(2000);
        return new HomePage(driver);
    }
}
