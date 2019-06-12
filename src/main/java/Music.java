public class Music {
    /**
     * TODO:
     * 1. Variable containing name of music
     * 2. Variable containing format
     * 3. Variable containing year of debut
     * 4. Variable containing artist
     * 5. Variable containing the category
     * 6. Constructor for declaring all the variables
     * 7. Method for making the object into JSONObject
     */

    private String artist;

    public Music(String artist)
    {
        this.artist = artist;
    }

    public String getArtist()
    {
        return this.artist;
    }


}
