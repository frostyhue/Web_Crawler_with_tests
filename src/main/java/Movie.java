import org.json.simple.JSONObject;

import java.util.List;

public class Movie extends JSONBase {
    private String title;
    private String director;
    private String category;
    private List<String> writers;
    private List<String> stars;
    Movie(String genre, String format, String year, String title, String director, String category, List<String> writers, List<String> stars) {
        super(genre, format, year);
        this.title = title;
        this.director = director;
        this.category = category;
        this.writers = writers;
        this.stars = stars;
    }

    public List<String> getStars() {
        return stars;
    }

    public List<String> getWriters() {
        return writers;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public JSONObject returnAsObj(){
        JSONObject obj = new JSONObject();
        obj.put("genre", getGenre());
        obj.put("title", getTitle());
        obj.put("category", getCategory());
        obj.put("format", getFormat());
        obj.put("year", getYear());
        obj.put("director", getDirector());
        obj.put("writers", getWriters());
        obj.put("stars", getStars());
        return obj;
    }
}
