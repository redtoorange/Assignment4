/**
 * AddressList.java - Description
 *
 * @author Andrew McGuiness
 * @version 12/2/2017
 */
public class AddressList {
    private ListNode head;
    private ListNode currentNode;

    // Non-Recursive
    public boolean isEmpty() {
        return ( head == null );
    }

    // Non-Recursive
    public void addToFront( String name, String tel, String email, String address, String dob ) {
        ListNode newNode = new ListNode( name, tel, email, address, dob );
        newNode.setNextNode( head );
        head = newNode;
    }


    public void addToBack( String name, String tel, String email, String address, String dob ) {
        if ( head == null )
            head = new ListNode( name, tel, email, address, dob );
        else
            getTailNode( head ).setNextNode( new ListNode( name, tel, email, address, dob ) );
    }

    private ListNode getTailNode( ListNode current ) {
        if ( current.getNextNode() == null )
            return current;
        else
            return getTailNode( current.getNextNode() );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(  );
        buildString( head, sb);

        return sb.toString();
    }

    private void buildString(ListNode currentNode, StringBuilder sb){
        if( currentNode != null) {
            sb.append( currentNode.toString() );
            sb.append( "\n" );
            buildString( currentNode.getNextNode(), sb );
        }
    }

    public String reverseToString() {
        StringBuilder sb = new StringBuilder(  );
        reverseBuildString( head, sb);

        return sb.toString();
    }

    private void reverseBuildString(ListNode currentNode, StringBuilder sb){
        if( currentNode != null) {
            reverseBuildString( currentNode.getNextNode(), sb );
            sb.append( currentNode.toString() );
            sb.append( "\n" );
        }
    }

    public AddressList reverse() {
        AddressList newList = new AddressList();

        reverseCopyToList( head, newList );

        return newList;
    }

    private void reverseCopyToList( ListNode current, AddressList list ){
        if( current != null ){
            list.addToFront( current.getName(), current.getTelephone(), current.getEmail(), current.getAddress(), current.getDateOfBirth() );
            reverseCopyToList( current.getNextNode(), list );
        }
    }


    public int sizeOf() {
        return countNodes( head );
    }

    // Recursive helper function to count the number of nodes in the list
    private int countNodes( ListNode node ) {
        if ( node == null )
            return 0;
        else
            return 1 + countNodes( node.getNextNode() );
    }


    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    // Data Query By Name -----------------------------------------------------------------
    //-------------------------------------------------------------------------------------

    public String emailByName( String name ) {
        ListNode node = findNodeByName( head, name );

        if ( node != null )
            return node.getEmail();
        else
            return "No matching data";
    }

    public String dobByName( String name ) {
        ListNode node = findNodeByName( head, name );

        if ( node != null )
            return node.getDateOfBirth();
        else
            return "No matching data";
    }

    public String phoneNumberByName( String name ) {
        ListNode node = findNodeByName( head, name );

        if ( node != null )
            return node.getTelephone();
        else
            return "No matching data";
    }

    private ListNode findNodeByName( ListNode current, String name ) {
        if ( current == null || current.getName().equals( name ) )
            return current;
        else
            return findNodeByName( current.getNextNode(), name );
    }

    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    // Data Query By Telephone ------------------------------------------------------------
    //-------------------------------------------------------------------------------------

    public String nameByPhoneNumber( String tel ) {
        ListNode node = findNodeByTelephone( head, tel );

        if ( node != null )
            return node.getName();
        else
            return "No matching data";
    }

    private ListNode findNodeByTelephone( ListNode current, String tel ) {
        if ( current == null || current.getTelephone().equals( tel ) )
            return current;
        else
            return findNodeByTelephone( current.getNextNode(), tel );
    }

    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------
}
