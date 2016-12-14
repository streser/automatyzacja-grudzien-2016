package pageObjectPattern;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected  WebElement element;



    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void insertText(WebDriver driver, String id, String text) {
        element = findElement(id);
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click(String id) {
        element = findElement(id);
        waitForElement(element);
        element.click();
    }
    public WebElement findElement(String id){
        return driver.findElement(By.id(id));
    }

    public boolean waitForElement( WebElement element){
        try {
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
        }catch (TimeoutException e){
        }
        return true;
    }

    public boolean waitForElementBy( By by){
        try {
            new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (TimeoutException e){
        }
        return true;
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

}
