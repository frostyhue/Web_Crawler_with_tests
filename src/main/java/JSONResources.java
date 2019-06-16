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
public class JSONResources {


    @GET
    @Path("searchCatalog/{title}")
    @Produces({MediaType.APPLICATION_JSON})
    public JSONObject getMovieJson(@PathParam("title") String title)
    {
        JSONObject result;
        Scraper scraper = new Scraper("http://i358097.hera.fhict.nl/", title);
        try {
            result = scraper.getResultAsJSON();
            if(result != null)
            {
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject errorObject = new JSONObject();
        errorObject.put("response", "ERROR TITLE NOT FOUND!");
        return errorObject;
    }

}
