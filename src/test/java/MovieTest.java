import junitparams.JUnitParamsRunner;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class MovieTest {
    /**
     * Checks if Movie inherits from JSONBase.
     */
    @Test
    public void asserIf_MovieObject_inheritsFromJSONBase(){
        Movie movieObj = new Movie();

        assertTrue(movieObj instanceof JSONBase);
    }

}
