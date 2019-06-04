import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpiderTest {
    @Test
    public void assertIfMaxNumberOfPagesIsSetTo()
    {
        //arrange
        Spider spider = new Spider();
        //act
        //assert
        assertEquals(10, spider.getMax_number_of_pages());
    }
}
