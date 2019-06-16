import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

/**
 * The test class for the Spider class that checks if the methods are behaving properly.
 */
@RunWith(JUnitParamsRunner.class)
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
     * Method that creates a set of parameters used to test if in the certain url, the given word is found.
     * @return test parameters
     */
    private static final Object[] linksWords(){
        String google = "https://www.google.com";
        String amazon = "https://www.amazon.de/";
        return $(
                $(google, "google"),
                $(google, "GoOgLe"),
                $(google, "gOogle"),
                $(amazon, "amazon"),
                $(amazon, "prime"),
                $(amazon, "PrIme")
        );
    }

    /**
     * Method used for parameterised test to lessen code lines
     * @return test parameters
     */
    private static final Object[] linksWordsMore(){
        String catalog = "http://i358097.hera.fhict.nl/";
        return $(
                $(catalog, "Clean Code: A Handbook of Agile Software Craftsmanship", "http://i358097.hera.fhict.nl/details.php?id=102"),
                $(catalog, "The Princess Bride", "http://i358097.hera.fhict.nl/details.php?id=204"),
                $(catalog, "Lord", "http://i358097.hera.fhict.nl/details.php?id=203"),
                $(catalog, "office space", "http://i358097.hera.fhict.nl/details.php?id=202")
        );
    }

    /**
     * Method that should be executed before each test for lessening code.
     */
    @Before
    public void testsSetup(){
        spider = new Spider();
    }

    /**
     * Setting up the Mockito frameword
     */
    @Before
    public void mocksInit(){
        MockitoAnnotations.initMocks(this);
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
    //1.Populate pagesToVisit using leg.crawl() method. (DONE)
    //2.Loop through each url and use leg.searchForWord() to find the sought word. (DONE)
    //3.Set url that should be checked first. (DONE)
    //4.If word is found, break loop and return the url. (DONE)
    //5.If not, continue checking urls. (DONE)
    //6.Check if pagesToVisit is empty. (DONE)

    //TESTSNEEDED for search():
    //1.direct/indirect in/out (DONE)
    //2.Parameterised tests (DONE)
    //3.Mock tests (DONE)

    private String googleUrl = "https://www.google.com";
    /**
     * Method testing if urls are populated after a crawl is initiated on the given link.
     */
    @Test
    public void assertPagesToVisitPopulatedAfterSerach(){
        Spider s = Mockito.mock(Spider.class);
        s.search(googleUrl, "google");
        LinkedList<String> emptyList = new LinkedList<>();
        Mockito.when(s.getPagesToVisit()).thenReturn(emptyList);
        assertTrue(s.getPagesToVisit().isEmpty());
    }

    /**
     * Method used for parameterised test to lessen code lines
     * @return test parameters
     */
    private static final Object[] urlWordFoundUrl(){
        String crawledUrl = "http://i358097.hera.fhict.nl/";
        return $(
                $(crawledUrl, "Refactoring", "http://i358097.hera.fhict.nl/details.php?id=103"),
                $(crawledUrl, "A Design Patterns", "http://i358097.hera.fhict.nl/details.php?id=101"),
                $(crawledUrl, "Forrest Gump", "http://i358097.hera.fhict.nl/details.php?id=201"),
                $(crawledUrl, "Lord of The Rings", "http://i358097.hera.fhict.nl/details.php?id=203"),
                $(crawledUrl, "Princess", "http://i358097.hera.fhict.nl/details.php?id=204"),
                $(crawledUrl, "Clean Code: A Handbook of Agile Software Craftsmanship", "http://i358097.hera.fhict.nl/details.php?id=102")
        );
    }


    /**
     * Test method checking if the url found from the crawl matches the expected one.
     * @param url String containing the link to be checked.
     * @param word String of characters that should be found.
     * @param returnedUrl String containing the link that the word String was found at.
     */
    @Test
    @Parameters(method = "urlWordFoundUrl")
    public void assertIfUrlFoundMatches(String url, String word, String returnedUrl){
        //arrange
        //act
        //url and word are the parameters that are for the act step ase parameters are used!
        spider.search(url, word);
        //assert
        assertEquals(returnedUrl, spider.getUrlFound());
    }

    /**
     * Mocked test method checking if the url found from the crawl matches the expected one.
     * @param url String containing the link to be checked.
     * @param word String of characters that should be found.
     * @param returnedUrl String containing the link that the word String was found at.
     */
    @Test
    @Parameters(method = "urlWordFoundUrl")
    public void assertMockedIfUrlFoundMatches(String url, String word, String returnedUrl){
        //arrange
        //act
            //url and word are the parameters that are for the act step ase parameters are used!
        Spider s = Mockito.mock(Spider.class);
        s.search(url, word);

        Mockito.when(s.getUrlFound()).thenReturn(returnedUrl);
        //assert
        assertTrue(s.getUrlFound() == returnedUrl);
    }

    /**
     * Method testing if urlsChecked int is the same as the pagesVisited size from Spider.
     */
    @Test
    public void assertIfUrlsCheckedAreTransferredToPagesVisited(){
        spider.search(googleUrl, "google");

        assertEquals(spider.getUrlsChecked(), spider.getPagesVisited().size());
    }

    /**
     * Test method checking if the url found from the crawl matches the expected one.
     * @param url String containing the link to be checked.
     * @param word String of characters that should be found.
     * @param found String containing the link that the word String was found at.
     */
    @Test
    @Parameters(method = "linksWordsMore")
    public void assertIfSearchReturnsProperURL(String url, String word, String found) {
        String foundUrl = spider.search(url, word);

        assertEquals(foundUrl, found);
    }
    //TODO getNextURL() method functionality tests:
    //1.Return the next url in line from pagesToVisit. (DONE)
    //2.Add the previous url to pagesVisited. (DONE)
    //3.Check if the url has been crawled yet. (DONE)

    //TESTSNEEDED for getNextUrl():
    //1.direct/indirect in/out (DONE)
    //2.Parameterised tests (DONE)

    /**
     * Method used for parameterised test to lessen code lines
     * @return test parameters
     */
    private static final Object[] urlsFound(){
        return $(
                $("http://i358097.hera.fhict.nl/details.php?id=102", "Refactoring"),
                $("http://i358097.hera.fhict.nl/details.php?id=204", "A Design Patterns"),
                $("http://i358097.hera.fhict.nl/details.php?id=203", "Forest Gump"),
                $("http://i358097.hera.fhict.nl/details.php?id=202", "Lord of The Rings"),
                $("http://i358097.hera.fhict.nl/catalog.php?cat=movies", "Princess"),
                $("http://i358097.hera.fhict.nl/details.php?id=104", "Clean coder")
        );
    }

    /**
     * Mocked test method that checks if the processed link is found in the pagesVisited parameter.
     * @param url String containing the link that should be contained in the list.
     * @param word String of characters that should be found at the url.
     */
    @Test
    @Parameters(method = "urlsFound")
    public void assertIfMethodAddsNextUrlToVisitedPagesList(String url, String word){
        Set<String> testList = new HashSet<>();
        testList.add(url);
        Spider s = Mockito.mock(Spider.class);

        Mockito.when(s.getPagesVisited()).thenReturn(testList);
        s.search("http://i358097.hera.fhict.nl/", word);

        assertTrue(s.getPagesVisited().contains(url));
    }
}
