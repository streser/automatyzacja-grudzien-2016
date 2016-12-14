package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 2016-12-14.
 */
public class CommentsPage extends BasePage{
    public CommentsPage(WebDriver driver) {
        super(driver);
    }

    public CommentsPage approveCommentByComment(String comment){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+comment+"')]//span[@class='approve']/a"));
        action.moveToElement(element).click().build().perform();
        return this;
    }


}
