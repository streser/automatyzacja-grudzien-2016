import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends Page {                                    //klasa Page powinna być abstrakcyjna
    public LoginPage(WebDriver driver) {                                //to jest konstruktor
        super(driver);
    }

    public AdminPage logIn(String login, String password) {
        insertText(By.id("user_login"), login);
        insertText(By.id("user_pass"), password);
        driver.findElement(By.id("wp-submit")).click();
        return new AdminPage(driver);
                                                                     //po zalogowaniu przechodzimy do strony AdminPage, dlatego ta metoda zwróci nową stronę AdminPage.
                                                                    //dlatego tu nie ma void, bo ta metoda coś zwraca - nową stronę Admin Page a wartość zwrócona będzie typu AdminPage
                                                                   //dlatego przed nazwą metody piszemy AdminPage
    }

}
