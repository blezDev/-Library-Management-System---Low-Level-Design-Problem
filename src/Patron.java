import java.util.Date;

public class Patron extends Account{
    private String memberId;
    private Date dateOfMembership;

    public Patron(String memberId, String name, Date dateOfMembership) {
        super.setName(name);
        this.memberId = memberId;
        this.dateOfMembership = dateOfMembership;
    }

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
