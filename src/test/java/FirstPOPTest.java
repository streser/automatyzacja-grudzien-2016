import PageObjects.*;
import base.Scenario;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class FirstPOPTest extends Scenario {

    WebDriver driver;
    private String text;
    private String title;
    private String url;

    @Test
    public void shouldLogInAndLogOut(){
        LoginPage loginPage = new LoginPage(driver);
        AdminPage adminPage = loginPage.logIn();
        AddNewPostPage addNewPostPage = adminPage.openAddNewPostPage();
        addNewPostPage.publishNewPost(title,text);
        LogOutPage logOutPage = addNewPostPage.logOut();
        logOutPage.open(url);
        HomePage homePage = new HomePage(driver);
        homePage.verifyPublishedPost(title);
    }
}
