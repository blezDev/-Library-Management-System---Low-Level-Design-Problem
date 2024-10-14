import java.util.Date;

public class BookItem extends Book {
    private BookStatus bookStatus = BookStatus.AVAILABLE;
    private Date BorrowedDate;


    public BookItem( Date borrowedDate, String ISBN, String title, String author, String publisherYear) {

        BorrowedDate = borrowedDate;
        super.setISBN(ISBN);
        super.setTitle(title);
        super.setAuthor(author);
        super.setPublisherYear(publisherYear);
    }
    public BookItem( BookStatus bookStatus, String ISBN, String title, String author, String publisherYear) {
        this.bookStatus = bookStatus;
        super.setISBN(ISBN);
        super.setTitle(title);
        super.setAuthor(author);
        super.setPublisherYear(publisherYear);
    }

    public BookItem() {
    }

    public boolean checkout() {
        if (bookStatus == BookStatus.AVAILABLE) {
            bookStatus = BookStatus.LOANED;
            BorrowedDate = new Date();
            return true;
        }
        return false;

    }

    public boolean checkout(String memberId) {
        if (bookStatus == BookStatus.RESERVED) {
            bookStatus = BookStatus.LOANED;
            BorrowedDate = new Date();
            return true;
        }
        return false;
    }


    public boolean checkin() {
        if (bookStatus == BookStatus.LOANED) {
            bookStatus = BookStatus.AVAILABLE;
            BorrowedDate = null;
            return true;
        }
        return false;
    }


    public boolean checkin(String memberId) {
        if (bookStatus == BookStatus.RESERVED) {
            bookStatus = BookStatus.AVAILABLE;
            BorrowedDate = null;
            return true;
        }
        return false;
    }

    public boolean reserved() {
        if (bookStatus == BookStatus.AVAILABLE) {
            bookStatus = BookStatus.RESERVED;
            return true;
        }
        return false;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public Date getBorrowedDate() {
        return BorrowedDate;
    }
}
