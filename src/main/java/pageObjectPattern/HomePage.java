package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 2016-12-13.
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text()='Some text')]")
    private WebElement post;


    public HomePage(WebDriver driver) {
        super(driver);
    }





    public boolean isPostPublished(String title) {
        waitForLoad(driver);
        boolean isPublished = true;
        try{
            waitForElementBy(By.xpath("//*[contains(text(),'"+title+"')]" ));
        }catch (NoSuchElementException e){
            isPublished = false;
        }
        return isPublished;
    }
}

//
//#post-226 > header > h1 > a
//
//
//
//        #post-224 > header > h1 > a
//
////*[@id="post-222"]/header/h1/a
//
//
//
////*[@id="post-226"]/header/h1/a