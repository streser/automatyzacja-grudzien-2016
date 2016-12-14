import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Scenario {

    protected WebDriver driver;
    protected String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        baseUrl = "http://streser.nazwa.pl/szkolenia/";
        driver.get(baseUrl + "wp-login.php?redirect_to=https%3A%2F%2Fszkolenieautoamatyzacjatech.wordpress.com%2Fwp-admin%2F&reauth=1/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
