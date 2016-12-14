package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class Page {
    public static final By USER_ICON = By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a");
    public static final By LOGOUT_BUTTON = By.xpath("//*[@id=\"wp-admin-bar-logout\"]/a");

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void insertText(By by, String text) {
        waitForElement(by);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }



    protected void checkAndClick(By by) {
        waitForElement(by);
        driver.findElement(by).click();
    }
    protected void click(WebElement webElement) {
        webElement.click();
    }

    protected void waitForElement(By by) {
        WebDriverWait wait= new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    protected void mouseOver(By by) {
        waitForElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).sendKeys("\t").perform();
    }

    protected void check(By by) {
        assertTrue(isElementPresent(by));
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void open(String url) {
        driver.get(url);
    }


}
