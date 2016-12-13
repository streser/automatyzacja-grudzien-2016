import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AdminPage extends Page {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage goToNewPost() {       //metoda zwraca (wartość?/obiekt?) typu AddNewPostPage -  patrz wyjaśnienie analogicznie jak w LoginPage
        return new AddNewPostPage(driver);
    }
}
