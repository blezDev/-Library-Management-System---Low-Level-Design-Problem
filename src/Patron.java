import java.util.Date;

public class Patron extends Account{
    private String memberId;
    private Date dateOfMembership;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(Date dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }
}
