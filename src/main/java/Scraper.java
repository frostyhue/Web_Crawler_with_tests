import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scraper {
    private String url;
    private Spider spider;

    Scraper(String url, String word){
        this.spider = new Spider();
        this.url = spider.search(url, word);
    }

    /**
     * Getter method.
     * @return String url.
     */
    public String getUrl() {
        return url;
    }

    public JSONObject getResultAsJSON() throws IOException {
        Document doc = Jsoup.connect(this.url).get();

        String title = doc.select("div.media-details h1").text();

        List<String> data = new ArrayList<>();

        Elements table = doc.select("div.media-details table td");
        for (Element element : table){
            data.add(element.text());
        }
        String type = data.get(0);
        String genre = data.get(1);
        String format = data.get(2);
        String year = data.get(3);
        if(type.equals("Movies")){
            String director = data.get(4);
            List<String> writers = Arrays.asList(data.get(5).split(", "));
            List<String> stars = Arrays.asList(data.get(6).split(", "));
            Movie movie = new Movie(genre, format, year, title, director, type, writers, stars);
            return movie.returnAsObj();
        }
        else if(type.equals("Music")){
            String artist = data.get(4);
            Music music = new Music(title, artist, format, year, type, genre);
            return music.returnAsObj();
        }
        else if(type.equals("Books")){
            List<String> authors = Arrays.asList(data.get(4).split(", "));
            String publisher = data.get(5);
            String ISBN = data.get(6);
            Book book = new Book(title,type, genre, format, year, authors, publisher, ISBN);
            return book.returnAsObj();
        }
        return null;
    }
}
