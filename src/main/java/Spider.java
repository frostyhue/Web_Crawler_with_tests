import java.util.List;
import java.util.Set;

public class Spider {
    private int max_number_of_pages;
    private Set<String> pagesVisited;
    private List<String> pagesToVisit;
    private String URLFound;

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

}
