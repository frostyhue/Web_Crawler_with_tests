import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("uni")
public class MovieResources {

    private List<Movie> movieList = new ArrayList<>();
    private List<String> actors = new ArrayList<>();
    private List<String> writers = new ArrayList<>();

    public MovieResources()
    {
        movieList.add(new Movie("genre", "format", "year", "title", "director", "category", writers, actors ));
    }

    @GET
    @Path("movies")
    @Produces({MediaType.TEXT_PLAIN})
    public String sayHello()
    {
        return "Hello, this service works !";
    }

    @GET
    @Path("movieJson")
    @Produces({MediaType.APPLICATION_JSON})
    public Movie getMovieJson()
    {
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
