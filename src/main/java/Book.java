import org.json.simple.JSONObject;

import java.util.List;

public class Book extends JSONBase{
    /** TODO:
     * 1. Variable for book title - done
     * 2. Variable for book category
     * 3. Variable for book genre
     * 4. Variable for format
     * 5. Variable for year
     * 6. Variable for authors
     * 7. Variable for publisher
     * 8. Variable for isbn
     * 9. Constructor for the book object
     * 10. Method for transforming to JSON
     */

   private String title;
   private String category;
   private List<String> authors;
   private String publisher;
   private String isbn;

   public Book(String title, String category, String genre, String format, String year, List<String> authors, String publisher, String isbn)
   {
       super(genre, format, year);
       this.title = title;
       this.authors = authors;
       this.publisher = publisher;
       this.category = category;
       this.isbn = isbn;
   }

    public String getTitle() {
        return title;
    }

    @Override
    public JSONObject getAsJSONObject(){
        JSONObject obj = new JSONObject();
        obj.put("title", this.title);
        obj.put("category", this.category);
        obj.put("genre", super.genre);
        obj.put("format", super.format);
        obj.put("year", super.year);
        obj.put("authors", this.authors);
        obj.put("publisher", this.publisher);
        obj.put("isbn", this.isbn);
        return obj;
    }
}
