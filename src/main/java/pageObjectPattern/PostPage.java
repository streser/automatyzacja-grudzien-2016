package pageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Administrator on 2016-12-13.
 */
public class PostPage extends BasePage {
    public PostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='wpbody-content']//a[contains(text(),'Add New')]")
    WebElement addNewButton;

    public NewPostPage goToAdddNewPostPage() {
        waitForElement(addNewButton);
        addNewButton.click();
        return new NewPostPage(driver);
    }


}
