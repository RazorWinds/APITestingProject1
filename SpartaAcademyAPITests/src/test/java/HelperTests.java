import Pojos.Spartan;
import Utilities.JSONSerialise;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HelperTests {
    @Test
    void testJSONDeserialize(){
        Spartan spartanPOJO = JSONSerialise.deserialize("SpartanSerialiseTest", Spartan.class);
        assertThat(spartanPOJO.getId(), is(67));
        assertThat(spartanPOJO.isGraduated(), is(true));
        assertThat(spartanPOJO.getFirstName(), is("Test"));
    }
    
    @Test
    void testJSONSerialise(){
        Spartan spartanPOJO = JSONSerialise.deserialize("SpartanSerialiseTest", Spartan.class);
        String convertedPOJO = JSONSerialise.serialise(spartanPOJO);
        assertThat(JSONSerialise.isJSONValid(convertedPOJO), is(true));
    }
}
