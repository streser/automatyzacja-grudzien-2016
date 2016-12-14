package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {
    WebDriver driver;

    public Page(WebDriver driver) {

        this.driver = driver;

    }
    protected void InsertText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
}
