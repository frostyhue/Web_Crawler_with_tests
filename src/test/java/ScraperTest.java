import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScraperTest {
    /**
     * Method asserts if when an obj of type Scraper is instantiated, the url of the object is returned by the Spider.
     */
    @Test
    public void assertIf_WhenScraperObjInstantiated_UrlIsSet(){
        String url = "http://i358097.hera.fhict.nl/";
        String word = "Lord of The Rings";
        Scraper scraper = new Scraper(url, word);

        assertEquals(scraper.getUrl(), "http://i358097.hera.fhict.nl/details.php?id=203");
    }
}