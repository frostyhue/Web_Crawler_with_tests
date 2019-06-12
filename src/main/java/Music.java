import org.json.simple.JSONObject;

public class Music {
    /**
     * TODO:
     * 1. Variable containing name of music - done
     * 2. Variable containing format - done
     * 3. Variable containing year of debut - done
     * 4. Variable containing artist - done
     * 5. Variable containing the category - done
     * 6. Constructor for declaring all the variables - done
     * 7. Method for making the object into JSONObject - done
     */

    private String title;
    private String artist;
    private String format;
    private String year;
    private String category;

    public Music(String title, String artist, String format, String year, String category)
    {
        this.title = title;
        this.artist = artist;
        this.format = format;
        this.year = year;
        this.category = category;
    }

    public String getArtist()
    {
        return this.artist;
    }

    public JSONObject getJSONFile()
    {
        JSONObject obj = new JSONObject();
        obj.put("title", this.title);
        obj.put("artist", this.artist);
        obj.put("year", this.year);
        obj.put("format", this.format);
        obj.put("category", this.category);

        return obj;
    }
}
