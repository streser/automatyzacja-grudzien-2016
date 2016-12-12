import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


/**
 * Created by Administrator on 2016-12-12.
 */
public class SampleTest {

    @Test
    public void shouldAddOneToOne(){
        assertThat(1 + 1, equalTo(2)); //sprawdź, że to jest rowne tyle
        //assertThat(list, hasItem("a"));

        Assert.assertEquals(1+1, 2); //sprawdz rownosc to kontra to
        Assert.assertTrue(1+1 == 2); //jak nie prawda, to zwraca wyjątek (?)

    }




}
