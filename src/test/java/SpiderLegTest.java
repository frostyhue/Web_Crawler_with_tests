import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.Parameters;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
The test class for the SpiderLeg class that checks if the methods are behaving properly.
 */
public class SpiderLegTest {
    //TODO SpiderLeg constructor
    //1.Instantiate a new linked list (DONE)
    //2.Set variable for the user agent

    @Test
    public void assertIfTheTypeInstancedIsLinkedList(){
        SpiderLeg leg = new SpiderLeg();
        assertTrue( leg.getUrls().isEmpty());
    }

    //TODO searchForWord() method:
    //1.Accept a word parameter as String
    //2.Return the body of the HTML doc where the word was found
    // - As lower case
    //3.Check if the body is empty

    //TODO getLinks() method:
    // - Returns the lists found by the searchForWord() method.

    //TODO crawl() method:
    //1.Connect to url
    //2.Get connection doc
    //3.Check if connection established, else return false
    //4.If document is empty return false
    //5.Retrieve all of the links on the webpage
    //6.Add each link to a list
    @Test
    public void testCrawlMethod()
    {
        //arrange
        SpiderLeg leg = new SpiderLeg();
        //act
        String url = "https://www.google.com";
        //assert
        assertEquals(true, leg.crawl(url));
    }
}
