/**
 * Created by Administrator on 2016-12-12.
 */
import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.core.IsEqual.equalTo;

public class SampleTest {

    @Test
    public void shouldAddOneToOne(){
        Assert.assertThat(1+1, equalTo(2));
    }


}
