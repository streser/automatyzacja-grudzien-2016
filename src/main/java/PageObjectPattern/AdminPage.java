package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-12-14.
 */
public abstract class AdminPage extends Page {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        Actions action = new Actions(driver);
        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a/img"));
        action.moveToElement(webElement).build().perform();
    //    WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
    //    webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-logout\"]/a"))));
        action.moveToElement(driver.findElement(By.linkText("Log Out"))).click().build().perform();
        //driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-logout\"]/a")).click();
        return new LoginPage(driver);
    }
}