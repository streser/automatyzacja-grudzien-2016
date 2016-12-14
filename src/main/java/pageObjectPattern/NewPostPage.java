package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 2016-12-13.
 */
public class NewPostPage extends BasePage {

    @FindBy(name = "post_title")
    private WebElement titleField;

    @FindBy(css = "#content")
    private WebElement contentField;

    @FindBy(id = "publish")
    private WebElement publishButton;


    public NewPostPage(WebDriver driver) {
        super(driver);
    }



    public NewPostPage insertTitle(String title){
        waitForElement(titleField);
        titleField.clear();
        titleField.sendKeys(title);
        return this;
    }

    public NewPostPage insertContent(String content){
        waitForElement(contentField);
        contentField.clear();
        contentField.sendKeys(content);
        return this;
    }

    public EditPostPage pressPublishButton(){
        waitForElement(publishButton);
        publishButton.click();
        return new EditPostPage(driver);
    }

    public EditPostPage publishNewPost(String title, String body) {
        insertTitle(title);
        insertContent(body);
        pressPublishButton();
        return new EditPostPage(driver);
    }
}
