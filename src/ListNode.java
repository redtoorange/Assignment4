/**
 * ListNode.java - This Class represents a single node within a LinkedList data
 * Structure (AddressList).  The class holds information about an "Address Book"
 * entry.  Once the node has been created, the data held becomes immutable,
 * but the Node's nextNode can be changed, allowing sorting or relocation.
 *
 * @author Andrew McGuiness
 * @version 12/2/2017
 */
public class ListNode {
    private final String name;
    private final String telephone;
    private final String email;
    private final String address;
    private final String dateOfBirth;
    private ListNode nextNode;

    /**
     * Create a new ListNode that has it's nextNode defaulted to null.
     *
     * @param name        name of this node
     * @param telephone   telephone number of this node
     * @param email       email address of this node
     * @param address     mailing address of this node
     * @param dateOfBirth date of birth for this node
     */
    public ListNode( String name, String telephone, String email,
                     String address, String dateOfBirth ) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get this ListNode's Next Node
     *
     * @return ListNode that comes after this one
     */
    public ListNode getNextNode() {
        return nextNode;
    }

    /**
     * Set this ListNode's Next Node
     *
     * @param nextNode ListNode that should follow this one
     */
    public void setNextNode( ListNode nextNode ) {
        this.nextNode = nextNode;
    }

    /**
     * Get this ListNode's Name
     *
     * @return String name
     */
    public String getName() {
        return name;
    }


    /**
     * Get this ListNode's Telephone Number
     *
     * @return String telephone number
     */
    public String getTelephone() {
        return telephone;
    }


    /**
     * Get this ListNode's Email Address
     *
     * @return String email address
     */
    public String getEmail() {
        return email;
    }


    /**
     * Get this ListNode's Mailing Address
     *
     * @return String address
     */
    public String getAddress() {
        return address;
    }


    /**
     * Get this ListNode's Date of Birth
     *
     * @return String date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }


    /**
     * Get the String representation of this ListNode, does not include data
     * about the next node.
     *
     * @return String representation of this ListNode
     */
    @Override
    public String toString() {
        return
                "Name: " + name + "\n" +
                        "\tTelephone: " + telephone + "\n" +
                        "\tEmail:     " + email + "\n" +
                        "\tAddress:   " + address + "\n" +
                        "\tDOB:       " + dateOfBirth;
    }
}
