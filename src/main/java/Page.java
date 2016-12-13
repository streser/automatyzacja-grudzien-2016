import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public abstract class Page {            //klasa Page ma byc abstrakcyjna!! dodaję "abstract" ręcznie wpisując
    protected final WebDriver driver;

    public Page(WebDriver driver) {  //to jest konstruktor
    this.driver = driver;

    }
}
