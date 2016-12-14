package PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public abstract class Page {
    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void insertTekst(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }
    public void webWait(By element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
    }

    public UUID randomTitle() {
        UUID temp = UUID.randomUUID();
        return temp;
    }
}
