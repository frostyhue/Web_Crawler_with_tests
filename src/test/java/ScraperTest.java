import org.json.simple.JSONObject;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScraperTest {
    /**
     * Method asserts if when an obj of type Scraper is instantiated, the url of the object is returned by the Spider.
     */
    @Test
    public void assertIf_WhenScraperObjInstantiated_UrlIsSet(){
        String url = "http://i358097.hera.fhict.nl/";
        String word = "Lord of The Rings";
        Scraper scraper = new Scraper(url, word);

        assertEquals(scraper.getUrl(), "http://i358097.hera.fhict.nl/details.php?id=203");
    }

    @Test
    public void assertIf_getResultAsJSON_ReturnsMovieAsProperJSONObject() throws IOException {
        String url = "http://i358097.hera.fhict.nl/";
        String word = "Lord of The Rings";
        Scraper scraper = new Scraper(url, word);

        List<String> writers = new ArrayList<>();
        writers.add("J.R.R. Tolkien");
        writers.add("Fran Walsh");
        writers.add("Philippa Boyens");
        writers.add("Peter Jackson");

        List<String> stars = new ArrayList<>();
        stars.add("Ron Livingston");
        stars.add("Jennifer Aniston");
        stars.add("David Herman");
        stars.add("Ajay Naidu");
        stars.add("Diedrich Bader");
        stars.add("Stephen Root");

        Movie movieObj = new Movie("Drama","Blu-ray","2001","The Lord of the Rings: The Fellowship of the Ring", "Peter Jackson", "Movies",writers, stars);
        JSONObject expected = movieObj.getJSONObject();

        assertEquals(expected, scraper.getResultAsJSON());
    }

    @Test
    public void assertIf_getResultAsJSON_ReturnsMusicAsProperJSONObject() throws IOException {
        String url = "http://i358097.hera.fhict.nl/";
        String word = "Elvis Forever";
        Scraper scraper = new Scraper(url, word);

        Music musicObj = new Music("Elvis Forever", "Elvis Presley", "Vinyl", "2015", "Music");
        JSONObject expected = musicObj.getJSONFile();

        assertEquals(expected, scraper.getResultAsJSON());
    }

    @Test
    public void assertIf_getResultAsJSON_ReturnsBookAsProperJSONObject() throws IOException {
        String url = "http://i358097.hera.fhict.nl/";
        String word = "A Design Patterns: Elements of Reusable Object-Oriented Software";
        Scraper scraper = new Scraper(url, word);

        List<String> authors = new ArrayList<>();
        authors.add("Erich Gamma");
        authors.add("Richard Helm");
        authors.add("Ralph Johnson");
        authors.add("John Vlissides");

        JSONObject obj = new JSONObject();
        obj.put("title", "A Design Patterns: Elements of Reusable Object-Oriented Software");
        obj.put("category", "Books");
        obj.put("genre", "Tech");
        obj.put("format", "Paperback");
        obj.put("year", "1994");
        obj.put("authors", authors);
        obj.put("publisher", "Prentice Hall");
        obj.put("ISBN", "978-0201633610");

        assertEquals(obj, scraper.getResultAsJSON());
    }
}