import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddBlogPostTest  {
    public static final String CORRECT_LOGIN = "Warsztatautomatyzacja";
    public static final String CORRECT_PASSWORD = "notsosimplepass123";
    public static final By WRITE_BUTTON = By.cssSelector("#wp-admin-bar-ab-new-post > a.ab-item > span");
    private ChromeDriver driver;


    @Before
    public void setUp() throws Exception {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void  shouldAddPostToBlog(){



        LoginPage lp = new LoginPage(driver);
        lp.open();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //po zalogowaniu się przejdziemy do strony Admin Page, więc:
        AdminPage ap = lp.logIn(CORRECT_LOGIN, CORRECT_PASSWORD);
       // do poprawy Assert.assertTrue(ap.isElementPresent(WRITE_BUTTON));

        //na stronie Admin Page będziemy chcieli dodać nowy post
        AddNewPostPage anp = ap.goToNewPost();


        BlogPrewievPage bpp = anp.publishNewPost("To jest tytył mojego postu", "To jest treść mojego postu");

        //na stronieHomePage będą widoczne dodane posty
        //na stronie BlogPrewievPage widzę dodany post
        assertTrue(bpp.postIsPublished("To jest tytył mojego postu: Dopisać sprawdzenie!"));



    }

}
