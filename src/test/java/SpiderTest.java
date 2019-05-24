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
    //3.Instantiate pagesToVisit as a LinkedList<String>.
    //4.Initialize urlFound as an empty string.
    //5.Instantiate leg as SpiderLeg object.

    @Test
    public void assertIfMaxNumberOfPagesIsSetTo20(){
        assertEquals(20, spider.getMax_Number_Of_Pages());
    }

    @Test
    public void assertIfpagesVisitedIsHashSet(){
        assertTrue(spider.getPagesVisited() instanceof HashSet);
    }

    @Test
    public void assertIfpagesToVisitIsLinkedList(){
        assertTrue(spider.getPagesToVisit() instanceof LinkedList);
    }

    //TODO search() method functionality tests
    //1.Populate pagesToVisit using leg.crawl() method.
    //2.Loop through each url and use leg.searchForWord() to find the sought word.
    //3.Set url that should be checked first.
    //4.If word is found, break loop and return the url.
    //5.If not, continue checking urls.
    //6.Check if pagesToVisit is empty.

    //TODO getNextURL() method functionality tests:
    //1.Return the next url in line from pagesToVisit.
    //2.Add the previous url to pagesVisited.
    //3.Check if the url has been crawled yet.

}
