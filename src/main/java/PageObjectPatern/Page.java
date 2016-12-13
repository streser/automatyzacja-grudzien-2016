package PageObjectPatern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public abstract class Page {
    WebDriver driver;
    public Page(WebDriver driver){
        this.driver=driver;
    }
    public void insertTekst(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public  void click(By by){
        driver.findElement(by).click();
    }
}
