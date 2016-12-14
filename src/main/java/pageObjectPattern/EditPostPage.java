package pageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Administrator on 2016-12-13.
 */
public class EditPostPage extends BasePage {

    public EditPostPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id ="message")
    private WebElement message;

    public String getMeassge(){
        waitForElement(message);
        return message.getText();
    }

    public MainPage isPostPublished() {
        return PageFactory.initElements(driver, MainPage.class);
    }
}
