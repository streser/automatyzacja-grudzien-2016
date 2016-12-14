import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-12-13.
 */
public class NewPostPage extends Page {

    public static final By TITLE_FIELD = By.cssSelector("input#title");
    private static final By BODY_FIELD = By.xpath("//*[@id=\"content\"]");
    private static final By PUBLISH_BUTTON = By.id("publish");
    //private static final By TEXT_FRAME = By.xpath("//*[@id=\"content-html\"]");

    private static final By AVATAR_ICON = By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a/img");
    private static final By SIGN_OUT_LINK = By.linkText("Log Out");
    private static final By ADDEDPOST = By.xpath("//*[@id=\"message\"]/p/text()");

    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    public NewPostPage publishNewPage(String title, String text) {
        insertText(TITLE_FIELD, title);
       // click(TEXT_FRAME);
        insertText(BODY_FIELD, text);
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(PUBLISH_BUTTON));


        click(PUBLISH_BUTTON);



        return this;
    }

    public LoginPage logOut() {

/*
        elem = find_element_by_selector(selector)
        ac = ActionChains(browser)
        ac.move_to_element(elem).move_by_offset(x_off, y_off).click().perform()


*/

        Actions action = new Actions(driver);


        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a/img"))).build().perform();

        //action.moveByOffset(we.getLocation().getX(),we.getLocation().getY());
   //     new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(SIGN_OUT_LINK));
        //action.moveByOffset(so.getLocation().getX(),so.getLocation().getY()).perform();
        action.moveToElement(driver.findElement(By.linkText("Log Out"))).click().build().perform();
      //  driver.findElement(SIGN_OUT_LINK).click();


        return new LoginPage(driver);
    }
}
