import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;


/*
Created by Administrator on 2016-12-12.
 */
public class SampleTest {

    @Test
    public void shouldAddOneToOne() {
        Assert.assertThat(1 + 1, equalTo(2));
    }

}
