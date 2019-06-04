import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SpiderTest {

    /**
     * Test to check if the max number of pages is set to 10
     */
    @Test
    public void assertIfMaxNumberOfPagesIsSetTo()
    {
        //arrange
        Spider spider = new Spider();
        //act
        //assert
        assertEquals(10, spider.getMax_number_of_pages());
    }

    /**
     * Test to check if pagesVisited set is a Hash set
     */

    @Test
    public void assertIfPagesVisitedIsAHashSet()
    {
        //arrange
        Spider spider = new Spider();
        //act
        //assert
        assertTrue(spider.getPagesVisited() instanceof HashSet);
    }

    /**
     * Test to check if the pagesToVisit list is a Linked List
     */
    @Test
    public void assertIfPagesToVisitIsALinkedList()
    {
        //arrange
        Spider spider = new Spider();
        //act
        //assert
        assertTrue(spider.getPagesToVisit() instanceof LinkedList);
    }

    /**
     * Test to check if the URL Found has been set
     */
    @Test
    public void assertIfURLFoundIsSet()
    {
        //arrange
        Spider spider = new Spider();
        //act
        //assert
        assertEquals("www.google.com", spider.getURLFound());
    }


    /**
     * Test to check if the SpiderLeg is not null after initializing Spider object
     */
    @Test
    public void assertIfLegIsNotNull()
    {
        //arrange
        Spider spider = new Spider();
        //act
        //assert
        assertNotNull(spider.getLeg());
    }

    /**
     * Test to check if pages are populated after a search
     */

    @Test
    public void assertPagesToVisitIsPopulatedAfterSearch()
    {
        //arrange
        Spider spider = new Spider();
        //act
        spider.search("https://www.google.com", "google");
        //assert
        assertTrue(!spider.getPagesToVisit().isEmpty());
    }
}
