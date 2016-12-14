package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login() {
        driver.get(baseUrl);
        insertText(By.id("user_login"), "Warsztatautomatyzacja");
        insertText(By.id("user_pass"), "notsosimplepass123");
        clickButton(By.id("wp-submit"));
        return new MainPage(driver);
    }

    public HomePage goToHomePage() {
       clickButton(By.xpath("//*[@id=\"backtoblog\"]/a"));
       return new HomePage(driver);
    }
}
