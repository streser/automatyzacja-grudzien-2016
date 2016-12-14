package login;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Administrator on 2016-12-13.
 */
public class AddNewPost extends Page {

    protected String postTitle_Name = "post_title";
    protected String publish_Id = "publish";
    protected String viewPost_Xpath = "//*[@id='message']/p";



    public AddNewPost(WebDriver driver) {
        super(driver);
    }

    public void addNewPost() {
        click(By.xpath("//*[@class='add-new-h2']"));
    }

    public void publicNewPost(String title, String txt) {
        enterTxt(By.name(postTitle_Name), title);
        enterTxt(By.xpath("//*[@class='wp-editor-area']"), title);
        click(By.id(publish_Id));
    }

    public void logOut() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[.='Howdy, warsztatautomatyzacja']"))).build().perform();
        waitForElement(By.xpath("//*[.='Log Out']"));
        action.moveToElement(driver.findElement(By.xpath("//*[.='Log Out']"))).build().perform();
        waitForElement(By.xpath("//*[.='Log Out']"));
        click(By.xpath("//*[.='Log Out']"));
    }

    public HomePage newHomePage() {
        return null;
    }

    public void checkNewPost() {
        Assert.assertEquals("Post published. View post", getTxt(By.xpath(viewPost_Xpath)));

    }
}
