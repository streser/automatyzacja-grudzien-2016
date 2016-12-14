package pageObjectPattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Administrator on 2016-12-13.
 */
public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);

    }


    Actions action = new Actions(driver);
    @FindBy(xpath = "//*[@id='menu-posts']//div[contains(text(),'Posts')]")
    private WebElement postTabSideDashboardButton;

    @FindBy(css = "#wp-admin-bar-my-account > a")
    private WebElement myAccountMouseHover;

    @FindBy(linkText = "Log Out")
    private WebElement logOutButton;

    @FindBy(id = "menu-comments")
    private WebElement commentstTabSideDashboardButton;

    public PostPage goToPostsPage() {
        waitForElement(postTabSideDashboardButton);
        postTabSideDashboardButton.click();
        return PageFactory.initElements(driver, PostPage.class);
    }

    public void mouseHoverMyAccount() throws InterruptedException {
        waitForLoad(driver);
        waitForElement(myAccountMouseHover);
       // action.moveToElement(myAccountMouseHover).build().perform();
    }

    public void pressLogOut() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('ab-item')[20].click()");
    }

    public void logOut() throws InterruptedException {
        mouseHoverMyAccount();
        pressLogOut();
    }

    public CommentsPage goToCommentsPage() {
        waitForElement(commentstTabSideDashboardButton);
        commentstTabSideDashboardButton.click();
        return new CommentsPage(driver);
    }
}


//*[@id="post-574"]/header/h1/a

//a[contains(text()='Some text')]