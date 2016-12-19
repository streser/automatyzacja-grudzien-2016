import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class Scenario2 {

    protected WebDriver driver;
    

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\New Folder\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "http://streser.nazwa.pl/szkolenia/wp-login.php";
        driver.get(url);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


}
