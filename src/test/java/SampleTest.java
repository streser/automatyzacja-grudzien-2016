import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class SampleTest {
    @Test
    public void shouldAddOneToOne() {
        Assert.assertThat(1 + 1, equalTo(2));



    }

}


