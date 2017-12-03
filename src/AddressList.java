/**
 * AddressList.java - The AddressList is a Singly Linked List data structure that maintains a collection of ListNodes.
 * Each ListNode represents a single entry in an "Address Book".  Methods are provided for searching the AddressList by
 * name or by telephone number.
 *
 * @author Andrew McGuiness
 * @version 12/2/2017
 */
public class AddressList {
    private static final String NO_MATCH = "No matching data.";
    private ListNode head;
    private ListNode currentNode;   //Not used, left in because the project specified it.

    /**
     * Does the AddressList contain any entries?
     *
     * @return true if the AddressList has 0 entries, false otherwise.
     */
    public boolean isEmpty() {
        return ( head == null );
    }

    /**
     * Add a new entry to the front of the AddressList.
     *
     * @param name    name of the new entry
     * @param tel     telephone number of the new entry
     * @param email   email address of the new entry
     * @param address address of the new entry
     * @param dob     date of birth of the new entry
     */
    public void addToFront( String name, String tel, String email, String address, String dob ) {
        ListNode newNode = new ListNode( name, tel, email, address, dob );
        newNode.setNextNode( head );
        head = newNode;
    }


    /**
     * Add a new entry to the end of the AddressList.
     *
     * @param name    name of the new entry
     * @param tel     telephone number of the new entry
     * @param email   email address of the new entry
     * @param address address of the new entry
     * @param dob     date of birth of the new entry
     */
    public void addToBack( String name, String tel, String email, String address, String dob ) {
        if ( head == null )
            head = new ListNode( name, tel, email, address, dob );
        else
            getTailNode( head ).setNextNode( new ListNode( name, tel, email, address, dob ) );
    }

    /** Recursive Helper for addToBack. */
    private ListNode getTailNode( ListNode current ) {
        if ( current.getNextNode() == null )
            return current;

        return getTailNode( current.getNextNode() );
    }

    /**
     * Get the String representation of this AddressList.
     *
     * @return String representation of AddressList.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString( head, sb );

        return sb.toString();
    }

    /** Recursive Helper for toString. */
    private void buildString( ListNode currentNode, StringBuilder sb ) {
        if ( currentNode != null ) {
            sb.append( currentNode.toString() );
            sb.append( "\n" );
            buildString( currentNode.getNextNode(), sb );
        }
    }

    /**
     * Get the String representation of this AddressList, but with the entries in reverse order.
     *
     * @return String representation of AddressList in reverse order.
     */
    public String reverseToString() {
        StringBuilder sb = new StringBuilder();
        reverseBuildString( head, sb );

        return sb.toString();
    }

    /** Recursive Helper for reverseToString. */
    private void reverseBuildString( ListNode currentNode, StringBuilder sb ) {
        if ( currentNode != null ) {
            reverseBuildString( currentNode.getNextNode(), sb );
            sb.append( currentNode.toString() );
            sb.append( "\n" );
        }
    }

    /**
     * Return a new AddressList that contains the same entries as this one, but in reverse order.  The new AddressList
     * is completely independent from the original.
     *
     * @return AddressList with the same entries but reversed order.
     */
    public AddressList reverse() {
        AddressList newList = new AddressList();

        reverseCopyToList( head, newList );

        return newList;
    }

    /** Recursive Helper for reverse. */
    private void reverseCopyToList( ListNode current, AddressList list ) {
        if ( current != null ) {
            list.addToFront( current.getName(), current.getTelephone(), current.getEmail(), current.getAddress(), current.getDateOfBirth() );
            reverseCopyToList( current.getNextNode(), list );
        }
    }


    /**
     * Get the number of entries in the AddressList.
     *
     * @return int number of entries in the AddressList
     */
    public int sizeOf() {
        return countNodes( head );
    }

    /** Recursive Helper for sizeOf. */
    private int countNodes( ListNode node ) {
        if ( node == null )
            return 0;

        return 1 + countNodes( node.getNextNode() );
    }


    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    // Data Query By Name -----------------------------------------------------------------
    //-------------------------------------------------------------------------------------

    /**
     * Search for a email address based on a name.
     *
     * @param name Name to use to search.
     * @return String email address of the matching data.
     */
    public String emailByName( String name ) {
        ListNode node = findNodeByName( head, name );

        if ( node != null )
            return node.getEmail();

        return NO_MATCH;
    }

    /**
     * Search for a date of birth based on a name.
     *
     * @param name Name to use to search.
     * @return String date of birth of the matching data.
     */
    public String dobByName( String name ) {
        ListNode node = findNodeByName( head, name );

        if ( node != null )
            return node.getDateOfBirth();

        return NO_MATCH;
    }

    /**
     * Search for a telephone number based on a name.
     *
     * @param name Name to use to search.
     * @return String telephone of the matching data.
     */
    public String phoneNumberByName( String name ) {
        ListNode node = findNodeByName( head, name );

        if ( node != null )
            return node.getTelephone();

        return NO_MATCH;
    }

    /** Recursive Helper for emailByName, dobByName and phoneNumberByName. */
    private ListNode findNodeByName( ListNode current, String name ) {
        if ( current == null || current.getName().equals( name ) )
            return current;

        return findNodeByName( current.getNextNode(), name );
    }

    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    // Data Query By Telephone ------------------------------------------------------------
    //-------------------------------------------------------------------------------------

    /**
     * Search for a name based on a telephone number.
     *
     * @param tel PhoneNumber to search with.
     * @return String name of the matching data.
     */
    public String nameByPhoneNumber( String tel ) {
        ListNode node = findNodeByTelephone( head, tel );

        if ( node != null )
            return node.getName();

        return NO_MATCH;
    }

    /** Recursive Helper for nameByPhoneNumber. */
    private ListNode findNodeByTelephone( ListNode current, String tel ) {
        if ( current == null || current.getTelephone().equals( tel ) )
            return current;

        return findNodeByTelephone( current.getNextNode(), tel );
    }
}
