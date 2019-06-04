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

    @Test
    public void assertIfPagesVisitedIsAHashSet()
    {
        //arrange
        Spider spider = new Spider();
        //act
        //assert
        assertTrue(spider.getPagesVisited() instanceof HashSet);
    }


    @Test
    public void assertIfPagesToVisitIsALinkedList()
    {
        //arrange
        Spider spider = new Spider();
        //act
        //assert
        assertTrue(spider.getPagesToVisit() instanceof LinkedList);
    }


    @Test
    public void assertIfURLFoundIsSet()
    {
        //arrange
        Spider spider = new Spider();
        //act
        //assert
        assertEquals("www.google.com", spider.getURLFound());
    }

    @Test
    public void assertIfLegIsNotNull()
    {
        //arrange
        Spider spider = new Spider();
        //act
        //assert
        assertNotNull(spider.getLeg());
    }
}
