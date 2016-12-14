package pageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 2016-12-14.
 */
public class ExistingPostPage extends BasePage {
    public ExistingPostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Log in")
    private WebElement logInButton;

    @FindBy(id = "author")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "comment")
    private WebElement commentField;

    @FindBy(id = "submit")
    private WebElement publicCommentButton;


    public ExistingPostPage insertName(String name){
        waitForElement(nameField);
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public ExistingPostPage insertComment(String comment){
        waitForElement(commentField);
        commentField.clear();
        commentField.sendKeys(comment);
        return this;
    }

    public ExistingPostPage insertEmail(String email){
        waitForElement(emailField);
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public ExistingPostPage pressPublicButton(){
        waitForElement(publicCommentButton);
        publicCommentButton.click();
        return this;
    }

    public LoginPage goToLogInPage(){
        waitForElement(logInButton);
        logInButton.click();
        return new LoginPage(driver);
    }


    public ExistingPostPage addComment(String name, String email, String comment) {
        insertName(name);
        insertEmail(email);
        insertComment(comment);
        pressPublicButton();
        return this;
    }



    public boolean isCommentAdded(String comment) {
        waitForLoad(driver);
        boolean isPublished = true;
        try{
            waitForElementBy(By.xpath("//*[contains(text(),'"+comment+"')]" ));
        }catch (NoSuchElementException e){
            isPublished = false;
        }
        return isPublished;
    }

}
