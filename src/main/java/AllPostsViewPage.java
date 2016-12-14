import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016-12-14.
 */
public class AllPostsViewPage extends Page {

    public AllPostsViewPage(WebDriver driver) {
        super(driver);
    }

    public CommentPostPage commentSelectedPost(By by) {
        AllPostsViewPage allPostsViewPage = new AllPostsViewPage(driver);
        //#post-1003 > td.post-title.page-title.column-title > strong > a
        //*[@id="post-1003"]/td[1]/div[2]/span[4]/a
        return new CommentPostPage(driver);

    }
}
