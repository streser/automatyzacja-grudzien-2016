import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2016-12-12.
 */

public class SampleTest {
@Test
    public void shouldAddOneToOne (){

    assertThat(1 + 1, equalTo (2));

}

}
