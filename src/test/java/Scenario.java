import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class Scenario {
    protected WebDriver driver;
    private static final String BASE_URL = "http://streser.nazwa.pl/szkolenia/wp-login.php";
    protected  String USERNAME ="Warsztatautomatyzacja";
    protected String PASSWORD ="notsosimplepass123";

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }


}
