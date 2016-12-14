import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by Administrator on 2016-12-14.
 */
public class AllPostsViewPageTest extends ScenarioTest {

    public static final By FIRST_POST = By.xpath("//*[@id=\"post-1003\"]/td[1]/div[2]/span[4]/a");

    @Test
    public void shouldShowAllPosts() {

        AllPostsViewPage allPostsViewPage = new AllPostsViewPage(driver);
        allPostsViewPage.commentSelectedPost(FIRST_POST);

    }

}
