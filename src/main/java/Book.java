public class Book {
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
   private String genre;
   private String format;
   private String year;
   private String author;
   private String publisher;
   private String isbn;

   public Book(String title, String category, String genre, String format, String year, String author, String publisher, String isbn)
   {
       this.title = title;
   }

    public String getTitle() {
        return title;
    }
}
