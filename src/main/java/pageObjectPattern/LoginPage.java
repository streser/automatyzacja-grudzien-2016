package pageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(css = "#backtoblog > a")
    private WebElement backToBlogHyperlink;

    @FindBy(id = "user_login")
    private WebElement userLoginField;

    @FindBy(id = "user_pass")
    private WebElement userPasswordField;

    @FindBy(id = "wp-submit")
    private WebElement submitLoginButton;

    public LoginPage pressSubmitButton() {
        waitForElement(submitLoginButton);
        submitLoginButton.click();
        return this;
    }

    public LoginPage insertUserLogin(String login) throws InterruptedException {
        waitForElement(userLoginField);
        Thread.sleep(1000);
        userLoginField.clear();
        userLoginField.sendKeys(login);
        return this;
    }

    public LoginPage insertUserPassword(String password) {
        waitForElement(userPasswordField);
        userPasswordField.clear();
        userPasswordField.sendKeys(password);
        return this;
    }

    public MainPage logInToBlog(String login, String password) throws InterruptedException {
        insertUserLogin(login);
        insertUserPassword(password);
        pressSubmitButton();
        return new MainPage(driver);
    }

    public HomePage pressBackToBlogHyperlink() {
        waitForElement(backToBlogHyperlink);
        backToBlogHyperlink.click();
        return new HomePage(driver);
    }

}
