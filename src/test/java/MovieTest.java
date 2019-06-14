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

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
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
    public void assertIf_MovieObject_getAsJSONObjectReturnsProperJson(){
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

        JSONObject result = movieObj.getAsJSONObject();

        assertEquals(result.get("genre"), genre);
        assertEquals(result.get("format"), format);
        assertEquals(result.get("year"), year);
        assertEquals(result.get("title"), title);
        assertEquals(result.get("director"), director);
        assertEquals(result.get("category"), category);
        assertEquals(result.get("writers"), writersList);
        assertEquals(result.get("stars"), starsList);
    }

    /**
     * Method that creates a set of parameters used to test if the proper JSONObject is returned
     */
    private static final Object[] getMovieParams(){
        List<String> writers = new ArrayList<>();
        writers.add("Charlie Kaufman");
        writers.add("Stephen King");
        writers.add("Quentin Tarantino");
        writers.add("Steven Spielberg");
        List<String> stars = new ArrayList<>();
        stars.add("Bruce Willis");
        stars.add("Chris Hemsworth");
        stars.add("Liam Hemsworth");
        return $(
                $("action", "Blu-Ray", "2014", "Avengers", "George Williams", "Movie", writers, stars),
                $("fantasy", "Blu-Ray", "2000", "Robocop", "George Williams", "Movie", writers, stars),
                $("action", "DVD", "2004", "Star Wars 3", "George Lucas", "Movie", writers, stars),
                $("sci-fi", "Blu-Ray", "2010", "Avatar", "George Williams", "Movie", writers, stars),
                $("horror", "Dvd rip", "2019", "Us", "Jprdan Peele", "Movie", writers, stars)
        );
    }

    /**
     * Parameterised test method checking if getAsJSONObject return proper parameters.
     */
    @Test()
    @Parameters(method = "getMovieParams")
    public void assertIf_MovieObject_getAsJSONObjectReturnsProperJsonParameterisedTests(String genre, String format, String year, String title, String director, String category, List<String> starsList, List<String> writersList){
        Movie movieObj = new Movie(genre,format,year,title,director,category, writersList, starsList);

        JSONObject result = movieObj.getAsJSONObject();

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
