import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AdminPage extends Page{

    protected WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        super(driver);
    }
    protected void tryLogOut() {
        clickElement(By.cssSelector("img.avatar.avatar-32"));
        clickElement(By.cssSelector("button.ab-sign-out"));
        //clickElement(By.xpath("//*[@id=\"wp-admin-bar-logout\"]/a"));
        //clickElement(By.cssSelector("#wp-admin-bar-logout > a"));
        //clickElement(By.linkText("Wyloguj się"));
        //clickElement(By.xpath("//*[@id=\"wp-admin-bar-logout\"]/a"));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#menu-posts > a > div.wp-menu-name")));
    }
}
