public class Librarian {
    BookInventory bookInventory = BookInventory.getInstance();

    public void addBook(BookItem book) {
        bookInventory.addBookItem(book);
    }

    public void removeBook(String ISBN) {
        bookInventory.removeBookItem(ISBN);
    }


}
