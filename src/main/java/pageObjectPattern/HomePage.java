package pageObjectPattern;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);

    }

    public void open() {

    }

    public boolean PostIsPublished(String title) {
        return true;
    }
}
