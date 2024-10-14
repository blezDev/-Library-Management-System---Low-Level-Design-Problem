import java.util.Date;

public class BookItem extends Book {
    private BookStatus bookStatus = BookStatus.AVAILABLE;
    private Date BorrowedDate;


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
