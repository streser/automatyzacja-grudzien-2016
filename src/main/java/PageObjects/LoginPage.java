package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-13.
 */
public class LoginPage extends BasePage {

    private final By LOGIN_FIELD = By.id("user_login");
    private final By PASSWORD_FIELD = By.id("user_pass");
    private final By LOGIN_BUTTON = By.id("wp-submit");

    private final String CORRECT_LOGIN = "warsztatautomatyzacja";
    private final String CORRECT_PASSWORD = "notsosimplepass123";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public AdminPage logIn() {
        tryLogIn(CORRECT_LOGIN, CORRECT_PASSWORD);
        return new AdminPage(driver);
    }

    protected void insertText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void tryLogIn(String username, String pass) {
        waitForVisible(LOGIN_FIELD);
        insertText(LOGIN_FIELD, username);
        insertText(PASSWORD_FIELD, pass);
        click(LOGIN_BUTTON);
    }

}
