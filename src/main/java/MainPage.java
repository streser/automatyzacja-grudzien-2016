import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;


/**
 * Created by Administrator on 2016-12-13.
 */
public class MainPage extends Page {

    public static final By POST_MENU = By.id("menu-posts");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage goToAddPostPage() {

        driver.findElement(POST_MENU).click();
        driver.findElement(By.linkText("Dodaj nowy")).click();
        return new AddNewPostPage(driver);
    }
}
