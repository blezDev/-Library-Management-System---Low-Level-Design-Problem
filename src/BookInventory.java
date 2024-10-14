import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookInventory implements Search, BookLending {

    private static BookInventory instance = null;

    private BookInventory() {
    }

    public static BookInventory getInstance() {
        if (instance == null) {
            synchronized (BookInventory.class) {
                if (instance == null) {  // Double-checked locking for thread safety
                    instance = new BookInventory();
                }
            }
        }
        return instance;
    }

    private final HashMap<String, BookItem> booksDB = new HashMap<>();

    private final HashMap<String, ArrayList<String>> bookLendDB = new HashMap<>();


    public void addBookItem(BookItem bookItem) {
        booksDB.put(bookItem.getISBN(), bookItem);
    }

    public boolean removeBookItem(String ISBN) {

        if (booksDB.containsKey(ISBN) && booksDB.get(ISBN).getBookStatus() == BookStatus.AVAILABLE) {
            booksDB.remove(ISBN);
            return true;
        }
        return false;
    }


    public boolean updateBookItem(BookItem bookItem) {
        if (booksDB.containsKey(bookItem.getISBN())) {
            booksDB.put(bookItem.getISBN(), bookItem);
            return true;
        }
        return false;

    }

    @Override
    public List<BookItem> searchByTitle(String title) {
        List<BookItem> bookItems = new ArrayList<>();
        for (BookItem bookItem : booksDB.values()) {
            if (bookItem.getTitle().equals(title)) {
                bookItems.add(bookItem);
            }
        }
        return bookItems;
    }

    @Override
    public List<BookItem> searchByAuthor(String author) {
        List<BookItem> bookItems = new ArrayList<>();
        for (BookItem bookItem : booksDB.values()) {
            if (bookItem.getAuthor().equals(author)) {
                bookItems.add(bookItem);
            }
        }
        return bookItems;
    }

    @Override
    public List<BookItem> searchByISBN(String ISBN) {
        List<BookItem> bookItems = new ArrayList<>();
        for (BookItem bookItem : booksDB.values()) {
            if (bookItem.getISBN().equals(ISBN)) {
                bookItems.add(bookItem);
            }
        }
        return bookItems;
    }

    @Override
    public void lendBook(String ISBN, String memberId) {
        if (booksDB.containsKey(ISBN)) {
            BookItem bookItem = booksDB.get(ISBN);
            bookItem.checkout();
            if (bookLendDB.containsKey(memberId)) {
                bookLendDB.get(memberId).add(bookItem.getISBN());
            } else {
                bookLendDB.put(memberId, new ArrayList<>(List.of(bookItem.getISBN())));
            }
        }
    }

    @Override
    public void returnBook(String ISBN, String memberId) {
        if (booksDB.containsKey(ISBN) && bookLendDB.containsKey(memberId)) {
            BookItem bookItem = booksDB.get(ISBN);
            bookItem.checkin();

            bookLendDB.get(memberId).remove(bookItem.getISBN());

        }
    }


    @Override
    public List<BookItem> getBooksForUser(String memberId) {
        List<BookItem> bookItems = new ArrayList<>();
        if (bookLendDB.containsKey(memberId)) {
            for (String ISBN : (bookLendDB.get(memberId))) {
                bookItems.add(booksDB.get(ISBN));
            }
        }
        return bookItems;
    }

    @Override
    public List<BookItem> availableBooks() {
        List<BookItem> bookItems = new ArrayList<>();
        for (BookItem bookItem : booksDB.values()) {
            if (bookItem.getBookStatus() == BookStatus.AVAILABLE) {
                bookItems.add(bookItem);
            }
        }
        return bookItems;
    }

    @Override
    public List<BookItem> borrowedBooks(String title) {
        List<BookItem> bookItems = new ArrayList<>();
        for (BookItem bookItem : booksDB.values()) {
            if (bookItem.getTitle().equals(title) && bookItem.getBookStatus() == BookStatus.LOANED) {
                bookItems.add(bookItem);
            }
        }
        return bookItems;
    }

    @Override
    public void reserveBook(String ISBN, String memberId) {
        if (booksDB.containsKey(ISBN) && booksDB.get(ISBN).getBookStatus() == BookStatus.AVAILABLE && !bookLendDB.containsKey(memberId)) {
            BookItem bookItem = booksDB.get(ISBN);
            bookItem.reserved();
            if (bookLendDB.containsKey(memberId)) {
                bookLendDB.get(memberId).add(bookItem.getISBN());
            } else {
                bookLendDB.put(memberId, new ArrayList<>(List.of(bookItem.getISBN())));
            }
        }
    }

    @Override
    public void cancelReservation(String ISBN, String memberId) {
        if (booksDB.containsKey(ISBN) && bookLendDB.containsKey(memberId)) {
            BookItem bookItem = booksDB.get(ISBN);
            bookItem.checkin(memberId);
            bookLendDB.get(memberId).remove(bookItem.getISBN());
        }
    }
}
