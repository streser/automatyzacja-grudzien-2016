package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
//import java.time.LocalDate;

public class AddNewPostPage extends Page {
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage publishNewPost(String title, String text) {
        InsertText(By.id("title"), title);
        InsertText(By.id("content"), text);
        driver.findElement(By.id("publish")).click();
        return new AddNewPostPage(driver);
    }

    public LoginPage LogOut() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a/img"))).build().perform();

        //WebDriverWait wait = new WebDriverWait(driver, 100);
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#wp-admin-bar-logout > a:nth-child(1)")));

        //driver.findElement(By.cssSelector("button.ab-sign-out")).click();
        action.moveToElement(driver.findElement(By.linkText("Log Out"))).click().build().perform();
        return new LoginPage(driver);
    }
}
