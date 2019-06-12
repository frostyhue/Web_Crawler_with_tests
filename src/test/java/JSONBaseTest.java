import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.Parameters;

import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class JSONBaseTest {

    /**
     * Checking if JSONBase class is abstract.
     */
    @Test
    public void assertJSONBase_IsAbstractClass(){
        boolean isAbstract = Modifier.isAbstract(JSONBase.class.getModifiers());

        assertTrue(isAbstract);
    }
}
