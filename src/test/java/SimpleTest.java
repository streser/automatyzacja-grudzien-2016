import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;


/**
 * Created by Administrator on 2016-12-12.
 */
public class SimpleTest {

    @Test
    public void shouldAddOneTest(){
        assertThat(1+1, equalTo(2));
        assertNotEquals(1+1, equalTo(3));
    }
}
