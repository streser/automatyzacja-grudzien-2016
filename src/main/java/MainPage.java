import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class MainPage extends Page{

    //konstruktor z parametrem
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //metoda goToNewPostPage() - otwiera nową strone AddNewPostPage
    public AddNewPostPage goToNewPostPage() {
        openAddNewPostPage();
        return new AddNewPostPage(driver);
    }
}
