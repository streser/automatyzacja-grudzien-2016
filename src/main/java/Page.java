import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class Page {

    public WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }
}
