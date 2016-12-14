import org.junit.After;
import org.junit.Before;

/**
 * Created by Administrator on 2016-12-13.
 */
public class TestScenario extends BaseFlow {
    @Before
    public void setUp() throws Exception {
        openPage("http://streser.nazwa.pl/szkolenia");

    }

    @After
    public void tearDown() throws Exception {
        claerCookies();
        closePage();
    }
}
