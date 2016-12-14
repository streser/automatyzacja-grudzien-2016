import PageObjects.*;
import base.Scenario;
import org.junit.Test;

/**
 * Created by Administrator on 2016-12-13.
 */
public class FirstPOPTest extends Scenario {

    private String text = "TEST123TITLE";
    private String title = "Test Text 123";

    @Test
    public void shouldLogInAndLogOut(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(BASE_URL+ "wp-login.php");
        AdminPage adminPage = loginPage.logIn();

        AddNewPostPage addNewPostPage = adminPage.openAddNewPostPage();
        addNewPostPage.publishNewPost(title,text);
        LogOutPage logOutPage = addNewPostPage.logOut();
        logOutPage.open(BASE_URL);
        HomePage homePage = new HomePage(driver);
        homePage.verifyPublishedPost(title);
    }
}
