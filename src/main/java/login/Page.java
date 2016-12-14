package login;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class Page {

    protected WebDriver driver;

    public Page(WebDriver driver){
        this.driver  = driver;
    }

    public void insertTxt(By by, String txt) {
        click(by);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(Keys.BACK_SPACE);
        driver.findElement(by).sendKeys(txt);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void enterTxt(By by, String txt){
        driver.findElement(by).sendKeys(txt);
    }


    public void move(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText("http://streser.nazwa.pl/szkolenia/wp-admin/profile.php")));
        action.moveToElement(driver.findElement(By.xpath("//*[@.='Log Out']"))).click();
    }

    public void waitForElement(By by) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, ""));
    }

    public String getTxt(By by){
        return driver.findElement(by).getText().toString();
    }


}
