import java.util.List;

public interface BookLending {

    public void lendBook(String ISBN, String memberId);

    public void returnBook(String ISBN, String memberId);

    public List<BookItem> getBooksForUser(String memberId);


    public List<BookItem> availableBooks();

    public List<BookItem> borrowedBooks();

    public void reserveBook(String ISBN, String memberId);

    public void cancelReservation(String ISBN, String memberId);


}
