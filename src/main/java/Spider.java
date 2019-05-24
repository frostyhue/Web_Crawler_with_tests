import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider {
    //TODO add functionality to Spider class:
    //1.Variable containing the max number of pages for search and create a getter method for it. (DONE)
    //2.Variable containing the pages already visited by the search algorithm and create a getter method for it. (DONE)
    //3.Variable containing the pages to yet be visited by the search algorithm and create a getter method for it. (DONE)
    //4.Variable containing the url that the sought word was found in and create a getter method for it. (DONE)
    //5.Constructor declaring all of the variables.
    //6.Search method for finding the word sought.
    //7.Method retrieving the next url in line.

    private int Max_Number_Of_Pages;
    private Set<String> pagesVisited;
    private List<String> pagesToVisit;
    private String urlFound;
    private SpiderLeg leg;

    public Spider(){
        this.Max_Number_Of_Pages = 20;
        this.pagesVisited = new HashSet<>();
        this.pagesToVisit = new LinkedList<>();
    }

    public String getUrlFound() {
        return urlFound;
    }

    public List<String> getPagesToVisit() {
        return pagesToVisit;
    }

    public Set<String> getPagesVisited() {
        return pagesVisited;
    }

    public int getMax_Number_Of_Pages() {
        return Max_Number_Of_Pages;
    }
}
