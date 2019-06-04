

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider {
    private int max_number_of_pages;
    private Set<String> pagesVisited;
    private List<String> pagesToVisit;
    private String URLFound;
    private SpiderLeg leg;

    public Spider()
    {
        this.max_number_of_pages = 10;
        this.pagesVisited = new HashSet<>();
        this.pagesToVisit = new LinkedList();
        this.URLFound = "";
        this.leg = new SpiderLeg();
    }

    public SpiderLeg getLeg()
    {
        return this.leg;
    }

    public int getMax_number_of_pages()
    {
        return this.max_number_of_pages;
    }

    public String getURLFound(){
        return this.URLFound;
    }

    public Set<String> getPagesVisited()
    {
        return this.pagesVisited;
    }

    public List<String> getPagesToVisit()
    {
        return this.pagesToVisit;
    }

    public String search(String url, String word)
    {
        leg.crawl(url);
        this.pagesToVisit.addAll(leg.getUrls());
        return URLFound;
    }

}
