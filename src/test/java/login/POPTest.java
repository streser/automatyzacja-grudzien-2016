package login;
import org.junit.Test;



/**
 * Created by Administrator on 2016-12-13.
 */
public class POPTest extends ScenarioTest{

    @Test
    public void should(){
        LoginPage lp = new LoginPage(driver);
        AdminPage ap = lp.login();
        AddNewPost anp = ap.goToNewPage();
        anp.addNewPost();
        anp.publicNewPost("title", "txt");
        anp.checkNewPost();
        anp.logOut();
    }
}
