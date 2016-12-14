import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AdminPage extends Page{

    protected WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        super(driver);
    }
    protected void tryLogOut() {
        //clickElement(By.cssSelector("img.avatar.avatar-32"));
        //clickElement(By.cssSelector("button.ab-sign-out"));
        //clickElement(By.xpath("//*[@id=\"wp-admin-bar-logout\"]/a"));
        //clickElement(By.cssSelector("#wp-admin-bar-logout > a"));
        //clickElement(By.linkText("Wyloguj się"));
        //clickElement(By.xpath("//*[@id=\"wp-admin-bar-logout\"]/a"));
        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(By.cssSelector("#wp-admin-bar-my-account > a"))).build().perform();
        action.moveToElement(driver.findElement(By.cssSelector("#wp-admin-bar-logout > a"))).build().perform();
        action.click(driver.findElement(By.cssSelector("#wp-admin-bar-logout > a"))).build().perform();
    }
}
