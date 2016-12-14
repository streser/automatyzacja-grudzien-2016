import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class Page {        //klasa Page ma byc abstrakcyjna!! dodaję "abstract" ręcznie wpisując



    protected WebDriver driver;

    public Page(WebDriver driver) {  //to jest konstruktor
    this.driver = driver;
    }

    public void open() {
        driver.get("http://streser.nazwa.pl/szkolenia/wp-login.php");
    }

    void insertText(By by, String tekst) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(tekst);
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
