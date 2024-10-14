import java.util.List;

public class Librarian {
    BookInventory bookInventory = BookInventory.getInstance();
    PatronSystem patronSystem = PatronSystem.getInstance();

    public void addBook(BookItem book) {
        bookInventory.addBookItem(book);
    }

    public void removeBook(String ISBN) {
        bookInventory.removeBookItem(ISBN);
    }

    public void addPatron(Patron patron) {
        patronSystem.addPatron(patron);
    }

    public void removePatron(Patron patron) {
        patronSystem.removePatron(patron);
    }

    public void updatePatron(Patron patron) {
        patronSystem.updatePatron(patron);
    }

    public List<BookItem> getPatronHistory(String memberId) {
      return patronSystem.getPatronHistory(memberId);
    }

    public List<BookItem> searchByTitle(String title) {
        return bookInventory.searchByTitle(title);
    }

    public List<BookItem> searchByAuthor(String author) {
        return bookInventory.searchByAuthor(author);
    }

    public List<BookItem> searchByISBN(String ISBN) {
        return bookInventory.searchByISBN(ISBN);
    }

    public void lendBook(String ISBN, String memberId) {
        bookInventory.lendBook(ISBN, memberId);
    }

    public void returnBook(String ISBN, String memberId) {
        bookInventory.returnBook(ISBN, memberId);
    }

    public List<BookItem> getAvailableBooks() {
        return bookInventory.availableBooks();
    }

    public List<BookItem> getCheckedOutBooks() {
        return bookInventory.borrowedBooks();
    }



}
