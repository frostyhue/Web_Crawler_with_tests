import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

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
        assertTrue(spider.getPagesToVisit() instanceof HashSet);
    }
}
