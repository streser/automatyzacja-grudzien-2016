package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewPostPage extends LoggedPage {
    private static final By TITLE_FIELD = By.cssSelector("input#title");
    private static final By TEXT_FIELD = By.cssSelector("textarea#content");
    private static final By PUBLISH_BUTTON = By.cssSelector("input#publish");

    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage publishNewPost(String title, String text) {
        insertText(TITLE_FIELD, title);
        insertText(TEXT_FIELD, text);
        click(PUBLISH_BUTTON);
        return this;
    }

}
