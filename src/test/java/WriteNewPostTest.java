import PageObjectPatern.*;
import org.junit.Test;

import java.util.UUID;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public class WriteNewPostTest extends Scenarios {

    @Test
    public void shouldWriteNewPost(){

        LoginPage lp = new LoginPage(driver);
        lp.open("https://streser.nazwa.pl/szkolenia/wp-admin/");
        MainPage ap = lp.logIn("Warsztatautomatyzacja","notsosimplepass123");
        AddNewPostPage adp = ap.goToNewPost();
        UUID temp = UUID.randomUUID();
        adp.publishNewPost(temp.toString(),"text");
        adp.logOut();
        HomePage hp = new HomePage(driver);
        hp.open("http://streser.nazwa.pl/szkolenia/");
        assertTrue(hp.iSPostPublishPost(temp.toString()));
        PostPage pp = hp.moveToNewPost();
        pp.publishNewComment();
        assertTrue(hp.isNewCommentPublished("xx"));

    }


}
