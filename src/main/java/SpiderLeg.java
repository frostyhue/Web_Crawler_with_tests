import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SpiderLeg {
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private List<String> links = new LinkedList<String>();
    private Document doc;
    private String url;
    private LinkedList<String> urls;

    SpiderLeg(){
        urls = new LinkedList<String>();
    }

    public LinkedList<String> getUrls() {
        return urls;
    }

    public boolean crawl(String url)
    {
        try{
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDoc = connection.get();
            this.doc = htmlDoc;
            if(doc == null)
            {return false;}
            else {
                if (connection.response().statusCode() == 200) {
                    System.out.println("\nCrawling site... Working on: " + url);
                }
                if (!connection.response().contentType().contains("text/html")) {
                    System.out.println("\nError... Did not retrieve HTML.");
                    return false;
                }
            }

            Elements linksOnPage = doc.select("a[href]");
            System.out.println("Found (" + linksOnPage.size() + ") links");
            for(Element link : linksOnPage)
            {
                this.links.add(link.absUrl("href"));
            }
            return true;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean searchForWord(String word){
        String html = doc.body().text().toLowerCase();
        return html.contains(word.toLowerCase());
    }
}
