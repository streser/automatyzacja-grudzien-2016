import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 13-Dec-16.
 */
public class LoginPage extends Page{


    private final By LOGIN_FIELD = By.id("user_login");
    private final By PASSWORD_FIELD = By.id("user_pass");
    private final By LOGIN_BUTTON = By.id("wp-submit");

    private final String CORRECT_LOGIN = "warsztatautomatyzacja";
    private final String CORRECT_PASSWORD = "notsosimplepass123";

    private final By GOBACKTOBLOGBUTTON = By.xpath("//*[@id=\"backtoblog\"]/a");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /*
    public void open(String url) {
        driver.get(url);
    }
    */


    public AdminPage logIn() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(LOGIN_BUTTON));
        tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
        return new AdminPage(driver);
    }

    protected void insertText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void tryLogIn(String username, String pass) {
        insertText(LOGIN_FIELD, username);
        insertText(PASSWORD_FIELD, pass);
        click(LOGIN_BUTTON);
    }

    public BlogPage GoToBlog(){
        click(GOBACKTOBLOGBUTTON);
        return new BlogPage(driver);
    }
}
