import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    /**
     * 1. Test to check if the book's title is instantiated.
     * 2. Test to check is the method to transform to JSON
     */

    @Test
    public void testCheckIfBookTitleIsInstantiated()
    {
        //arrange
        String title = "some title";
        //act
        Book book = new Book(title);
        //assert
        assertEquals(title, book.title);
    }

}
