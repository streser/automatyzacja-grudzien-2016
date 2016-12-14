package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AdminPage extends Page {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPost goToNewPage() {
        click(By.xpath("//*[@id='menu-posts']/a/div[2]//parent::*/div[3]"));
        return new AddNewPost(driver);
    }
}
