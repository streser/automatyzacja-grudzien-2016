/**
 * Created by Administrator on 2016-12-13.
 */

import org.junit.Test;
import org.openqa.selenium.By;

public class MyFirstSeleniumTest extends SeleniumTest {

    @Test
    public void shouldLoginAndLogout() throws Exception {
        insertText(By.id("user_login"), "warsztatautomatyzacja");
        insertText(By.id("user_pass"), "notsosimplepass123");
        checkAndClick(By.id("wp-submit"));
        checkAndClick(By.cssSelector("img.avatar.avatar-32"));
        checkAndClick(By.cssSelector("button.ab-sign-out"));;
    }
}

