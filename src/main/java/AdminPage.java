import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 13-Dec-16.
 */
public class AdminPage extends Page {

    public static final By POSTSBUTTON = By.xpath("//*[@id=\"menu-posts\"]/a/div[3]");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public NewPostPage goToNewPostPage() {

        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(POSTSBUTTON));
        driver.findElement(POSTSBUTTON).click();
        driver.findElement(By.linkText("Add New")).click();
        return new NewPostPage(driver);
    }

}
