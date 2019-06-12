import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.Parameters;

import java.io.IOException;
import java.util.LinkedList;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * The test class for the SpiderLeg class that checks if the methods are behaving properly.
 */
@RunWith(JUnitParamsRunner.class)
public class SpiderLegTest {
    //OVERVIEW tests that are included into the test class:
    //1.Indirect input
    //2.Direct input
    //3.Indirect output
    //4,Direct output
    //5.Parameterised tests

    //TODO SpiderLeg constructor
    //1.Instantiate a new linked list (DONE)
    //2.Set variable for the user agent (DONE)

    /**
     * Test method that checks after a SpiderLeg object is created, if the parameter urls isEmpty returns true.
     */
    @Test
    public void assertIfTheTypeInstancedIsLinkedList() {
        SpiderLeg leg = new SpiderLeg();
        assertTrue(leg.getUrls().isEmpty());
    }

    //TODO searchForWord() method:
    //1.Accept a word parameter as String (DONE)
    //2.Return the body of the HTML doc where the word was found (DONE)
    // - As lower case (DONE)
    //3.Check if the body is empty (DONE)

    /**
     * Method that creates a set of parameters used to test if in the certain url, the given word is found.
     */
    private static final Object[] getUrlWordTrue(){
        String crawledUrl = "http://i358097.hera.fhict.nl/";
        String noFences = "http://i358097.hera.fhict.nl/details.php?id=303";
        String cc = "http://i358097.hera.fhict.nl/details.php?id=102";
        String lotr = "http://i358097.hera.fhict.nl/details.php?id=203";
        return $(
                $(cc, "Clean Code: A Handbook of Agile Software Craftsmanship"),
                $(crawledUrl, "Books"),
                $("http://i358097.hera.fhict.nl/catalog.php?cat=books", "catalog"),
                $(crawledUrl, "movies"),
                $(crawledUrl, "music"),
                $(crawledUrl, "suggest"),
                $(crawledUrl, "view details"),
                $(noFences, "no fences"),
                $(lotr, "lord"),
                $(lotr, "rings"),
                $(noFences, "1990")
        );
    }
    /**
     * Parametrised test method that uses getUrlWordFalse() as a method parameter to test the sets of urls and word.
     * @param url String containing the URL of the web-page that will be crawled.
     * @param word String that contains the word of sequence of words that need to be found.
     */
    @Test
    @Parameters(method = "getUrlWordFalse")
    public void assertSearchForWordReturnsFalseWhenWordNotFound(String url, String word){

        SpiderLeg leg = new SpiderLeg();
        leg.crawl(url);
        assertFalse(leg.searchForWord(word));
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertIf_crawl_ThrowsExceptionWhenUrlDoesntExist(){
        SpiderLeg leg = new SpiderLeg();
        String badUrl = "google.com";
        leg.crawl(badUrl);
    }

    /**
     * Method that creates a set of parameters used to test if in the certain url, the given word is not found.
     */
    private static final Object[] getUrlWordFalse(){
        String crawledUrl = "http://i358097.hera.fhict.nl/";
        String noFences = "http://i358097.hera.fhict.nl/details.php?id=303";
        String cc = "http://i358097.hera.fhict.nl/details.php?id=102";
        String lotr = "http://i358097.hera.fhict.nl/details.php?id=203";
        return $(
                $(lotr, "Clean Code: A Handbook of Agile Software Craftsmanship"),
                $(lotr, "Design Patterns"),
                $("http://i358097.hera.fhict.nl/catalog.php?cat=books", "Forrest Gump"),
                $(crawledUrl, "google"),
                $(crawledUrl, "masterpiece"),
                $(crawledUrl, "fontys"),
                $(crawledUrl, "view dettails"),
                $(cc, "no fences"),
                $(cc, "lord"),
                $(noFences, "rings"),
                $(cc, "1990")
        );
    }

    /**
     * Parametrised test method that uses getUrlWordTrue() as a method parameter to test the sets of urls and word.
     * @param url String containing the URL of the web-page that will be crawled.
     * @param word String that contains the word of sequence of words that need to be found.
     */
    @Test
    @Parameters(method = "getUrlWordTrue")
    public void assertSearchForWordReturnsTrueWhenWordFound(String url, String word){
        SpiderLeg leg = new SpiderLeg();
        leg.crawl(url);
        assertTrue(leg.searchForWord(word));
    }
    /**
     * Test method that checks if the method searchForWord() has a block that checks for empty doc.
     */
    @Test
    public void assertSearchForWordIfChecksForEmptyDoc(){
        SpiderLeg leg = new SpiderLeg();
        String word = "any word";
        assertFalse(leg.searchForWord(word));
    }

    //TODO getLinks() method:
    // - Returns the lists found by the searchForWord() method.

    //TODO crawl() method:
    //1.Connect to url
    //2.Get connection doc
    //3.Check if connection established, else return false
    //4.If document is empty return false
    //5.Retrieve all of the links on the webpage
    //6.Add each link to a list

    /**
     * Test method assuring that when a bad url is given, returns false.
     */
    @Test
    public void assertIf_crawl_AddsUrls(){
        SpiderLeg s = new SpiderLeg();

        String url = "http://i358097.hera.fhict.nl/catalog";

        boolean result = s.crawl(url);

        assertFalse(result);
    }
    /**
     * This test method checks the crawl method.
     * It asserts that the method returns true
     * when the url is provided to it.
     */
    @Test
    public void testCrawlMethod() {
        //arrange
        SpiderLeg leg = new SpiderLeg();
        //act
        String url = "https://www.google.com";
        //assert
        assertEquals(true, leg.crawl(url));
    }
}
