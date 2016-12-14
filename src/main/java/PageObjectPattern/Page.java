package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class Page{

    protected WebDriver driver;
    String baseUrl = "http://streser.nazwa.pl/szkolenia/wp-login.php";
    public Page(WebDriver driver) {
        this.driver = driver;
    }
    public void insertText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public void clickButton(By by) {
        driver.findElement(by).click();
    }
}
