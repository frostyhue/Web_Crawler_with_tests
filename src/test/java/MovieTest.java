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

    /**
     * Test if JSON object returned matches parameters
     */
    @Test
    public void assertIf_MovieObject_getJSONObjectReturnsProperJson(){
        String genre = "fantasy";
        String format = "DVD";
        String year = "2019";
        String title = "LoTR";
        String director = "John Wick";
        String category = "fantasy";
        List<String> starsList = new ArrayList<>();
        List<String> writersList = new ArrayList<>();
        starsList.add("star");
        writersList.add("writer");

        Movie movieObj = new Movie(genre,format,year,title,director,category, writersList, starsList);

        JSONObject result = movieObj.getJSONObject();

        assertEquals(result.get("genre"), genre);
        assertEquals(result.get("format"), format);
        assertEquals(result.get("year"), year);
        assertEquals(result.get("title"), title);
        assertEquals(result.get("director"), director);
        assertEquals(result.get("category"), category);
        assertEquals(result.get("writers"), writersList);
        assertEquals(result.get("stars"), starsList);
    }

}
