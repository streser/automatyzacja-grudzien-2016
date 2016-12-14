package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends Page{


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage goToAddNewPostPage() {

        driver.findElement(By.linkText("Posts")).click();
        driver.findElement(By.linkText("Add New")).click();
        return new AddNewPostPage(driver);
    }
}
