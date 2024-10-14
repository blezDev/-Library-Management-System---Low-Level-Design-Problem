import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Librarian librarian = new Librarian();
        librarian.addBook(new BookItem(new Date(),"123213421kvbkhv", "The Catcher in the Rye", "J.D. Salinger", "1951"));
        librarian.addPatron(new Patron("123", "John Doe", new Date()));
        librarian.lendBook("123213421kvbkhv", "123");
        System.out.println(librarian.getPatronHistory("123"));

    }
}