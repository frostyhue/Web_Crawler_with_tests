import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookTest {
    /**
     * 1. Test to check if the book's title is instantiated.
     * 2. Test to check is the method to transform to JSON
     */

//    @Test
//    public void testCheckIfBookTitleIsInstantiated()
//    {
//        //arrange
//        String title = "some title";
//        //act
//        Book book = new Book(title);
//        //assert
//        assertEquals(title, book.title);
//    }


    @Test
    public void testCheckBookTitle()
    {
        //arrange
        String title = "some title";
        //act
        Book book = new Book(title, "", "", "", "", new ArrayList<>(), "", "");
        //assert
        assertEquals(title, book.getTitle());
    }


    @Test
    public void testBookJSONReturn()
    {
        //arrange
        Book book = new Book("title", "category", "genre", "format", "year", new ArrayList<>(), "publisher", "isbn");
        //act

        //assert
        assertEquals("{\"year\":\"year\",\"isbn\":\"isbn\",\"genre\":\"genre\",\"format\":\"format\",\"publisher\":\"publisher\",\"title\":\"title\",\"category\":\"category\",\"authors\":[]}", book.getJSONObject().toJSONString());
    }
}
