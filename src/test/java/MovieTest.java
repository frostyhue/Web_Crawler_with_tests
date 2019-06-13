import junitparams.JUnitParamsRunner;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MovieTest {
    /**
     * Checks if Movie inherits from JSONBase.
     */
    @Test
    public void asserIf_MovieObject_inheritsFromJSONBase(){
        List<String> starsList = new ArrayList<>();
        List<String> writersList = new ArrayList<>();
        starsList.add("asd");
        writersList.add("Writer");
        Movie movieObj = new Movie("fantasy", "DVD", "2019", "Lord Of The Rings", "John Wick", "Fantasy", writersList, starsList );

        assertTrue(movieObj instanceof JSONBase);
    }


}
