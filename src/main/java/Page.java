import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;


public abstract class Page {
    protected final WebDriver driver;
    //public String baseUrl = "https://szkolenieautoamatyzacjatech.wordpress.com";
    public String baseUrl = "http://stalma.ch/testautom";

    public Page(WebDriver driver) {
        this.driver = driver;
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

    protected void openPageUrl(String urlPage) {
        driver.get(baseUrl + urlPage);
    }

    protected void clickElement(By byParameters) {
        driver.findElement(byParameters).click();
    }
    protected void insertText(By byElement, String text) {
        driver.findElement(byElement).clear();
        driver.findElement(byElement).sendKeys(text);
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}