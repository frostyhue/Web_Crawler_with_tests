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
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class MovieTest {
    /**
     * Checks if Movie inherits from JSONBase.
     */
    @Test
    public void asserIf_MovieObject_inheritsFromJSONBase(){
        //arrange
        List<String> starsList = new ArrayList<>();
        List<String> writersList = new ArrayList<>();
        //act
        starsList.add("asd");
        writersList.add("Writer");
        Movie movieObj = new Movie("fantasy", "DVD", "2019", "Lord Of The Rings", "John Wick", "Fantasy", writersList, starsList );
        //assert
        assertThat("The movieObj extends class JSONBase.", movieObj instanceof JSONBase, equalTo(true));
    }

    /**
     * Test if JSON object returned matches parameters
     */
    @Test
    public void assertIf_MovieObject_returnAsObjReturnsProperJson(){
        //arrange
        String genre = "fantasy";
        String format = "DVD";
        String year = "2019";
        String title = "LoTR";
        String director = "John Wick";
        String category = "fantasy";
        List<String> starsList = new ArrayList<>();
        List<String> writersList = new ArrayList<>();
        //act
        starsList.add("star");
        writersList.add("writer");

        Movie movieObj = new Movie(genre,format,year,title,director,category, writersList, starsList);

        JSONObject result = movieObj.returnAsObj();
        //assert
        assertThat("Genre parameter from JSONObject returns expected value.",result.get("genre"), equalTo(genre));
        assertThat("Format parameter from JSONObject returns expected value.",result.get("format"), equalTo(format));
        assertThat("Year parameter from JSONObject returns expected value.",result.get("year"), equalTo(year));
        assertThat("Title parameter from JSONObject returns expected value.",result.get("title"), equalTo(title));
        assertThat("Director parameter from JSONObject returns expected value.",result.get("director"), equalTo(director));
        assertThat("Category parameter from JSONObject returns expected value.",result.get("category"), equalTo(category));
        assertThat("Writers parameter from JSONObject returns expected value.",result.get("writers"), equalTo(writersList));
        assertThat("Stars parameter from JSONObject returns expected value.",result.get("stars"), equalTo(starsList));
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
     * Parameterised test method checking if returnAsObj return proper parameters.
     */
    @Test()
    @Parameters(method = "getMovieParams")
    public void assertIf_MovieObject_returnAsObjReturnsProperJsonParameterisedTests(String genre, String format, String year, String title, String director, String category, List<String> starsList, List<String> writersList){
        //arrange
        //act
            //url and word are the parameters that are for the act step ase parameters are used!
        Movie movieObj = new Movie(genre,format,year,title,director,category, writersList, starsList);

        JSONObject result = movieObj.returnAsObj();
        //assert
        assertEquals("Genre parameter from JSONObject returns expected value.",result.get("genre"), genre);
        assertEquals("Format parameter from JSONObject returns expected value.",result.get("format"), format);
        assertEquals("Year parameter from JSONObject returns expected value.", result.get("year"), year);
        assertEquals("Title parameter from JSONObject returns expected value.",result.get("title"), title);
        assertEquals("Director parameter from JSONObject returns expected value.",result.get("director"), director);
        assertEquals("Category parameter from JSONObject returns expected value.", result.get("category"), category);
        assertEquals("Writers parameter from JSONObject returns expected value.", result.get("writers"), writersList);
        assertEquals("Stars parameter from JSONObject returns expected value." ,result.get("stars"), starsList);
    }
}
