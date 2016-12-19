import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public class Scenarios {
    protected WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    private static final String ADRES_ADMIN = "https://streser.nazwa.pl/szkolenia/wp-admin/";
    private static final String LOGIN = "Warsztatautomatyzacja";
    private static final String PASSWORD = "notsosimplepass123";
    private static final String ADRES = "http://streser.nazwa.pl/szkolenia/";
    private static final String EMAIL = "pawdady@wp.pl";
    private static final String TABLE = "posts-filter";
    private String hardCommend = "F0A112C2-A4CC-4495-AB43-CC7031BD1F99";

    public String getHardCommend() {
        return hardCommend;
    }

    public void setHardCommend(String hardCommend) {
        this.hardCommend = hardCommend;
    }

    private UUID post =  UUID.randomUUID();
    private UUID comment =  UUID.randomUUID();

    public void setPost(UUID post) {
        this.post = post;
    }

    public void setComment(UUID comment) {
        this.comment = comment;
    }

    public UUID getPost(){
        return post;
    }

    public UUID getComment(){
        return comment;
    }

    public static String getTABLE() {
        return TABLE;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

    public static String getAdresAdmin() {
        return ADRES_ADMIN;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getADRES() {
        return ADRES;
    }



    @Before
    public void setUp() throws Exception {
//        driver = new FirefoxDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @After
    public void tearDown() throws Exception {
//        driver.close();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
