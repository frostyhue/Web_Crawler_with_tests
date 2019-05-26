import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * The test class for the Spider class that checks if the methods are behaving properly.
 */
public class SpiderTest {
    //OVERVIEW tests that are included into the test class:
    //1.Indirect input
    //2.Direct input
    //3.Indirect output
    //4,Direct output
    //5.Mock tests
    //6.Parameterised tests

    Spider spider;

    /**
     * Method that should be executed before each test for lessening code.
     */
    @Before
    public void testsSetup(){
        spider = new Spider();
    }

    //TODO constructor functionality tests
    //1.Initialize max-number-of-pages to a reasonable number, e.g. 20. (DONE)
    //2.Instantiate pagesVisited as a HashSet<String>. (DONE)
    //3.Instantiate pagesToVisit as a LinkedList<String>. (DONE)
    //4.Initialize urlFound as an empty string. (DONE)
    //5.Instantiate leg as SpiderLeg object. (DONE )

    //TESTSNEEDED for constructor:
    //1.Indirect in/out (DONE)

    /**
     * Method testing if the maximum number of pages is 20.
     */
    @Test
    public void assertIfMaxNumberOfPagesIsSetTo20(){
        assertEquals(20, spider.getMax_Number_Of_Pages());
    }

    /**
     * Method testing if the pagesVisited variable is of type HashSet.
     */
    @Test
    public void assertIfpagesVisitedIsHashSet(){
        assertTrue(spider.getPagesVisited() instanceof HashSet);
    }

    /**
     * Method testing if the pagesToVisit variable is of type LinkedList.
     */
    @Test
    public void assertIfpagesToVisitIsLinkedList(){
        assertTrue(spider.getPagesToVisit() instanceof LinkedList);
    }

    /**
     * Method testing if the urlFound string variable is empty after Spider object in instantiated.
     */
    @Test
    public void assertIfurlFoundIsEmptyString(){
        assertEquals("", spider.getUrlFound());
    }

    /**
     * Method testing if the leg object is not equal to null.
     */
    @Test
    public void assertIfLegIsNotNull(){
        assertNotNull(spider.getLeg());
    }

    //TODO search() method functionality tests
    //1.Populate pagesToVisit using leg.crawl() method.
    //2.Loop through each url and use leg.searchForWord() to find the sought word.
    //3.Set url that should be checked first.
    //4.If word is found, break loop and return the url.
    //5.If not, continue checking urls.
    //6.Check if pagesToVisit is empty.

    //TESTSNEEDED for search():
    //1.direct/indirect in/out
    //2.Parameterised tests
    //3.Mock tests

    @Test
    public void assertPagesToVisitPopulatedAfterSerach(){
        
        spider.search("https://www.google.com", "google");

        assertTrue(!spider.getPagesToVisit().isEmpty());
    }

    //TODO getNextURL() method functionality tests:
    //1.Return the next url in line from pagesToVisit.
    //2.Add the previous url to pagesVisited.
    //3.Check if the url has been crawled yet.

    //TESTSNEEDED for getNextUrl():
    //1.direct/indirect in/out
    //2.Parameterised tests

}
