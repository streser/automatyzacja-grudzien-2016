import PageObjectPatern.*;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Pawel_D on 2016-12-13.
 */
public class WriteNewPostTest extends Scenarios {
Scenarios sc = new Scenarios();




    @Test
    public void shouldWriteNewPost(){

        LoginPage lp = new LoginPage(driver);
        lp.open(sc.getAdresAdmin());
        MainPage ap = lp.logIn(sc.getLOGIN(), sc.getPASSWORD());
        AddNewPostPage adp = ap.goToNewPost();

        adp.publishNewPost(sc.getPost().toString(),"text");
        adp.logOut();
        HomePage hp = new HomePage(driver);
        hp.open(sc.getADRES());
        assertTrue(hp.iSPostPublishPost(sc.getPost().toString()));

        PostPage pp = hp.moveToNewPost(sc.getPost().toString());
        pp.publishNewComment(sc.getPost().toString(),sc.getEMAIL(), sc.getPost().toString());
        assertTrue(hp.isNewCommentPublished(sc.getPost().toString()));
    }

    @Test
    public void shouldWriteNewComment() {
        HomePage hp = new HomePage(driver);
        hp.open(sc.getADRES());
        PostPage pp = hp.moveToNewPost(sc.getHardCommend());
        pp.publishNewComment(sc.getComment().toString(),sc.getEMAIL(), sc.getComment().toString());
        assertTrue(hp.isNewCommentPublished(sc.getComment().toString()));
    }




}
