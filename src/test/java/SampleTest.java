import org.junit.Test;

import static org.hamcrest.core.IsEqual.*;
import static org.junit.Assert.*;


public class SampleTest {

    @Test
    public void shouldAddOneToOne(){
        assertThat(1+1, equalTo(2));
    }

}
