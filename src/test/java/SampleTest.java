
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Pawel_D on 2016-12-12.
 */


public class SampleTest {
    @Test
    public void shouldAddOneToOne() {
        assertThat( 1+1,equalTo(2));

        Assert.assertEquals(2,1+1);
        Assert.assertTrue(1+1 == 2);
    }



}
