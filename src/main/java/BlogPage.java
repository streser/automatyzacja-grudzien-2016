import org.openqa.selenium.WebDriver;


public class BlogPage extends Page{
    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public void findPost(String title) {
        openPageUrl("/");
    }
}
