import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class HomePage extends Page{

    //konstruktor z parametrem
    public HomePage(WebDriver driver) {
        super (driver);
    }

    //metoda
    public void openMainPage() {
        driver.findElement(By.id("backtoblog")).click();
    }

    public boolean postIsPublished(String title) {
        driver.findElement(By.linkText(title));
        return (true);
    }
}
