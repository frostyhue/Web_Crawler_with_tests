import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Spider class checking the url and word provided and returning the link in which the word is found for the first time.
 */
public class Spider {
    //TODO add functionality to Spider class:
    //1.Variable containing the max number of pages for search and create a getter method for it. (DONE)
    //2.Variable containing the pages already visited by the search algorithm and create a getter method for it. (DONE)
    //3.Variable containing the pages to yet be visited by the search algorithm and create a getter method for it. (DONE)
    //4.Variable containing the url that the sought word was found in and create a getter method for it. (DONE)
    //5.Constructor declaring all of the variables. (DONE)
    //6.Search method for finding the word sought.
    //7.Method retrieving the next url in line.

    private int Max_Number_Of_Pages;
    private Set<String> pagesVisited;
    private List<String> pagesToVisit;
    private String urlFound;
    private SpiderLeg leg;
    private int urlsChecked = 0;

    /**
     * Constructor of class Spider, initializing each variable that will be used in the logic for the methods in this class.
     */
    public Spider(){
        this.Max_Number_Of_Pages = 20;
        this.pagesVisited = new HashSet<>();
        this.pagesToVisit = new LinkedList<>();
        this.urlFound = "";
        this.leg = new SpiderLeg();
    }

    /**
     * Getter method for returning urlFound.
     * @return urlFound string containing the url with the sought word.
     */
    public String getUrlFound() {
        return urlFound;
    }

    /**
     * Getter method for returning pagesToVisit.
     * @return pagesToVisit linked list that contains all of the urls that have been found and will be checked.
     */
    public List<String> getPagesToVisit() {
        return pagesToVisit;
    }

    /**
     * Getter method for returning pagesVisited.
     * @return pagesVisited hash set that contains all of the urls that have already been checked.
     */
    public Set<String> getPagesVisited() {
        return pagesVisited;
    }

    /**
     * Getter method for returning Max_Number_Of_Pages.
     * @return Max_Number_Of_Pages integer containing the maximum number of pages that can be checked (20).
     */
    public int getMax_Number_Of_Pages() {
        return Max_Number_Of_Pages;
    }

    /**
     * Getter method for returning leg.
     * @return leg object of type SpiderLeg that is used to crawl through the provided url and return the urls that have been found.
     */
    public SpiderLeg getLeg() {
        return leg;
    }

    public String NextURL(){
        String nextUrl;
        nextUrl = this.pagesToVisit.remove(0);
        pagesVisited.add(nextUrl);
        return nextUrl;
    }

    /**
     * Method utilizing the SpiderLeg object to search for the word needed and returning the link.
     * @param url string containing the link that should be crawled.
     * @param word string containing the sequence of characters needed to be found so that the link can be returned.
     * @return string containing the url that the word was found on.
     */
    public String search(String url, String word){
        leg.crawl(url);
        this.pagesToVisit.addAll(leg.getUrls());
        return urlFound;
    }

    /**
     * Getter method returning the number of urls that have been checked.
     * @return urlsChecked int.
     */
    public int getUrlsChecked() {
        return urlsChecked;
    }
}
