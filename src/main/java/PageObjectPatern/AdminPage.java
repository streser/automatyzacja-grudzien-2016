package PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public class AdminPage extends Page{
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage goToNewPost() {
        click(By.linkText("Wpisy"));
        click(By.linkText("Dodaj Nowy"));
        return new AddNewPostPage(driver);
    }
}
