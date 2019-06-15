import org.json.simple.JSONObject;

public abstract class JSONBase {
     String year;
     String genre;
     String format;

    JSONBase(String genre, String format, String year){
        this.year = year;
        this.format = format;
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getFormat() {
        return format;
    }

    public JSONObject returnAsObj(){
        JSONObject obj = new JSONObject();
//        obj.put("genre", this.getGenre());
//        obj.put("format", this.getFormat());
//        obj.put("year", this.getYear());
        return obj;
    }
}
