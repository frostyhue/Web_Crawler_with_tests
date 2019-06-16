import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("uni")
public class MovieResources {

    private List<JSONObject> movieList = new ArrayList<>();
    private List<String> actors = new ArrayList<>();
    private List<String> writers = new ArrayList<>();

    @GET
    @Path("movies")
    @Produces({MediaType.TEXT_PLAIN})
    public String sayHello()
    {
        return "Hello, this service works !";
    }

    @GET
    @Path("movieJson/{title}")
    @Produces({MediaType.APPLICATION_JSON})
    public JSONObject getMovieJson(@PathParam("title") String title)
    {
        JSONObject result;
        Scraper scraper = new Scraper("http://i358097.hera.fhict.nl/", title);
        try {
            result = scraper.getResultAsJSON();
            movieList.add(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(movieList.size() > 0)
        {
            return movieList.get(0);
        }
        else
        {
            throw new RuntimeException("there are no movies in the list");
        }
    }

}
