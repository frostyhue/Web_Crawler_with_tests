import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MusicTest {
    /**
     * TODO:
     * 1. Test to check if the initialization (i.e. of the song name) is successful - done
     * 2. Test to check if the method to transform into JSON object works - done
     */

    /**
     * This test is now obsolete since we no longer test the public variable which is now private.
     */
//    @Test
//    public void testGetArtist()
//    {
//        //arrange
//        String artist = "Some artist";
//
//        //act
//        Music music = new Music(artist);
//
//        //assert
//        assertEquals(artist, music.artist);
//    }

    /**
     * This test tests the getter of the Music class.
     */
    @Test
    public void testGetterArtist()
    {
        //arrange
        String artist = "Some artist";

        //act
        Music music = new Music("title", artist, "format", "year", "category", "genre");

        //assert
        assertEquals(artist, music.getArtist());
    }

    /**
     * This test if the method to transform the Music object to JSON is working properly
     */
    @Test
    public void testJSONMethodReturn()
    {
        //arrange
        Music music = new Music("title", "artist", "format", "year", "category", "genre");

        //act

        //assert
        assertEquals("{\"artist\":\"artist\",\"year\":\"year\",\"genre\":\"genre\",\"format\":\"format\",\"title\":\"title\",\"category\":\"category\"}", music.getJSONObject().toJSONString());

    }

}
