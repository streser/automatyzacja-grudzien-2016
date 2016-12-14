package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class HomePage extends Page {


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public boolean isPostPublished(String title) {
        boolean isPostPublished = true;
        try {
           waitForElementPresence(By.xpath("//a[contains(text()='"+title.toUpperCase()+"')]"));
        } catch (NoSuchElementException e){
         isPostPublished = false;
        }
        return isPostPublished;
    }
}
