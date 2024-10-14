import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatronSystem {
    ArrayList<Patron> patrons = new ArrayList<>();
    BookInventory bookInventory = BookInventory.getInstance();
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public Patron findPatron(String memberId) {
        for (Patron patron : patrons) {
            if (patron.getMemberId().equals(memberId)) {
                return patron;
            }
        }
        return null;
    }

    public void updatePatron(Patron patron) {
        Patron existingPatron = findPatron(patron.getMemberId());
        if (existingPatron != null) {
            existingPatron = patron;
        }
    }


    public void getPatronHistory(String memberId){
        Patron patron = findPatron(memberId);
        if (patron != null) {
            List<BookItem> books = bookInventory.getBooksForUser(memberId);
            for (BookItem book : books) {
                System.out.println(book.getTitle() + " " + book.getISBN());
            }
        }
    }



}
