/**
 * Created by Administrator on 2016-12-14.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void open(String url) {
        driver.get(url);
    }

    protected void checkAndClick(By by) {
        waitForElement(by);
        driver.findElement(by).click();
    }

    private void waitForElement(By by) {
        WebDriverWait wait= new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void insertText(By by, String text) {
        waitForElement(by);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

}
