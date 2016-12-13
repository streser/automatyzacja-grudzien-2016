import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends Page {      //klasa Page powinna być abstrakcyjna
    public LoginPage(WebDriver driver) {  //to jest konstruktor
        super(driver);
    }

    public AdminPage logIn() {              //po zalogowaniu przechodzimy do strony AdminPage, dlatego ta metoda zwróci nową stronę AdminPage.
                                            //dlatego tu nie ma void, bo ta metoda coś zwraca - nową stronę Admin Page a wartość zwrócona będzie typu AdminPage
                                            //dlatego przed nazwą metody piszemy AdminPage
        return new AdminPage(driver);
    }
}
