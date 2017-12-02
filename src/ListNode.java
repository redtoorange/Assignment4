/**
 * ListNode.java - Description
 *
 * @author Andrew McGuiness
 * @version 12/2/2017
 */
public class ListNode {
    private String name;
    private String telephone;
    private String email;
    private String address;
    private String dateOfBirth;
    private ListNode nextNode;

    public ListNode( String name, String telephone, String email, String address, String dateOfBirth ) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode( ListNode nextNode ) {
        this.nextNode = nextNode;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth( String dateOfBirth ) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return
                "Name: " + name + "\n" +
                "\tTelephone: " + telephone + "\n" +
                "\tEmail:     " + email + "\n"  +
                "\tAddress:   " + address + "\n"  +
                "\tDOB:       " + dateOfBirth;
    }
}
