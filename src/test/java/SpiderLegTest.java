import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.Parameters;

import java.util.LinkedList;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * The test class for the SpiderLeg class that checks if the methods are behaving properly.
 */
@RunWith(JUnitParamsRunner.class)
public class SpiderLegTest {
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
        String google = "https://www.google.com";
        String w3school = "https://www.w3schools.com/";
        String amazon = "https://www.amazon.de/";
        return $(
                $(google, "google"),
                $(google, "GoOgLe"),
                $(google, "gOogle"),
                $(w3school, "html and css"),
                $(w3school, "HTML and CSS"),
                $(w3school, "Learn SQL"),
                $(w3school, "Learn SQL"),
                $(w3school, "LeArN SqL"),
                $(amazon, "amazon"),
                $(amazon, "prime"),
                $(amazon, "PrIme")
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

    /**
     * Method that creates a set of parameters used to test if in the certain url, the given word is not found.
     */
    private static final Object[] getUrlWordFalse(){
        String google = "https://www.google.com";
        String w3school = "https://www.w3schools.com/";
        String amazon = "https://www.amazon.de/";
        return $(
                $(google, "<html"),
                $(google, "<style"),
                $(google, "<script"),
                $(w3school, "cars"),
                $(w3school, "Fontys"),
                $(w3school, "hard drive"),
                $(amazon, "<html"),
                $(amazon, "<style"),
                $(amazon, "<script")
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
