package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

/**
 * Created by Administrator on 2016-12-13.
 */
public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    Actions action = new Actions(driver);

    public void clickToGoToPostPage() {
        click(By.xpath("//*[@id='menu-posts']/a/div[3]"));
    }

    public PostPage goToPostPage() {
        clickToGoToPostPage();
        return new PostPage(driver);
    }

    public void mouseoverToElement() throws InterruptedException {
        waitForElement(By.cssSelector("#wp-admin-bar-my-account > a"));
    //    WebElement myAccount = driver.findElement(By.cssSelector("#wp-admin-bar-my-account > a"));

    }

    public void pressLogOut() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('ab-item')[20].click()");
    }

    public void logOut() throws InterruptedException {
        mouseoverToElement();
        pressLogOut();
    }
}
