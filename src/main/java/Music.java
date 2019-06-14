import org.json.simple.JSONObject;

public class Music extends JSONBase {
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
    private String category;

    public Music(String title, String artist, String format, String year, String category, String genre)
    {
        super(genre, format, year);
        this.title = title;
        this.artist = artist;
        this.category = category;
    }

    public String getArtist()
    {
        return this.artist;
    }

    @Override
    public JSONObject getAsJSONObject()
    {
        JSONObject obj = new JSONObject();
        obj.put("title", this.title);
        obj.put("artist", this.artist);
        obj.put("genre", super.genre);
        obj.put("year", super.year);
        obj.put("format", super.format);
        obj.put("category", this.category);

        return obj;
    }


}
