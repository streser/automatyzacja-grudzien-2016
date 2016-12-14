package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AdminPage extends LoggedPage {

    public static final By POSTS = By.cssSelector("li#menu-posts");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage openAddNewPostPage() {

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(POSTS));
        driver.findElement(POSTS).click();
        driver.findElement(By.linkText("Add New")).click();
        return new AddNewPostPage(driver);
    }

}
