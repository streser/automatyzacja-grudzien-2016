import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertTrue;

public class FirstSeleniumTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithCorrectCredentials(){
        insertText(By.id("user_login"),"warsztatautomatyzacja" );
        insertText(By.id("user_pass"),"notsosimplepass123" );
        driver.findElement(By.id("wp-submit")).click();
        assertTrue(isElementPresent(By.cssSelector("img.avatar.avatar-32")));
        driver.findElement(By.cssSelector("img.avatar.avatar-32")).click();
        driver.findElement(By.cssSelector("button.ab-sign-out")).click();
        assertTrue(isElementPresent(By.cssSelector("button.menu-toggle.x")));
    }

}
