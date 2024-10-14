import java.util.List;

public interface Search {
    public List<BookItem> searchByTitle(String title);

    public List<BookItem> searchByAuthor(String author);

    public List<BookItem> searchByISBN(String ISBN);


}
