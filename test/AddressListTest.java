import org.junit.Assert;
import org.junit.Test;

/**
 * AddressList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 2, 2017</pre>
 */
public class AddressListTest {
    /**
     * Method: isEmpty()
     */
    @Test
    public void testIsEmpty() throws Exception {
        AddressList list = new AddressList();

        Assert.assertTrue( "isEmpty Failed", list.isEmpty() );

        list.addToFront( "", "", "", "", "" );

        Assert.assertTrue( "isEmpty Failed", !list.isEmpty() );
    }

    /**
     * Method: addToFront()
     */
    @Test
    public void testAddToFront() throws Exception {
        AddressList list = new AddressList();

        Assert.assertTrue( "AddToFront Failed", list.isEmpty() );
        Assert.assertTrue( "AddToFront Failed", list.sizeOf() == 0 );

        list.addToFront( "", "", "", "", "" );

        Assert.assertTrue( "AddToFront Failed", !list.isEmpty() );
        Assert.assertTrue( "AddToFront Failed", list.sizeOf() == 1 );

        list.addToFront( "", "", "", "", "" );

        Assert.assertTrue( "AddToFront Failed", !list.isEmpty() );
        Assert.assertTrue( "AddToFront Failed", list.sizeOf() == 2 );
    }

    /**
     * Method: addToBack()
     */
    @Test
    public void testAddToBack() throws Exception {
        AddressList list = new AddressList();

        Assert.assertTrue( "addToBack Failed", list.isEmpty() );
        Assert.assertTrue( "addToBack Failed", list.sizeOf() == 0 );

        list.addToBack( "", "", "", "", "" );

        Assert.assertTrue( "addToBack Failed", !list.isEmpty() );
        Assert.assertTrue( "addToBack Failed", list.sizeOf() == 1 );

        list.addToBack( "", "", "", "", "" );

        Assert.assertTrue( "addToBack Failed", !list.isEmpty() );
        Assert.assertTrue( "addToBack Failed", list.sizeOf() == 2 );
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
        AddressList list = new AddressList();

        System.out.println( "Empty List: \n" + list );

        list.addToFront( "1", "8049331266",
                "redtoorange@gmail.com", "817 Canyon Ridge",
                "10291987" );

        list.addToBack( "2", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );

        list.addToBack( "3", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );
        list.addToBack( "4", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );
        list.addToBack( "5", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );

        System.out.println( "Big List: \n" + list);
    }

    /**
     * Method: reverseToString()
     */
    @Test
    public void testReverseToString() throws Exception {
        AddressList list = new AddressList();

        System.out.println( "Reverse Empty List: \n" + list.reverseToString() );

        list.addToFront( "1", "8049331266",
                "redtoorange@gmail.com", "817 Canyon Ridge",
                "10291987" );

        list.addToBack( "2", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );

        list.addToBack( "3", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );
        list.addToBack( "4", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );
        list.addToBack( "5", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );

        System.out.println( "Reverse Big List: \n" + list.reverseToString() );
    }

    /**
     * Method: reverse()
     */
    @Test
    public void testReverse() throws Exception {
        AddressList list = new AddressList();

        list.addToFront( "1", "8049331266",
                "redtoorange@gmail.com", "817 Canyon Ridge",
                "10291987" );

        list.addToBack( "2", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );

        list.addToBack( "3", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );
        list.addToBack( "4", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );
        list.addToBack( "5", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );

        AddressList reversed = list.reverse();

        System.out.println( "Original List: \n" + list );
        System.out.println( "Reversed List: \n" + reversed );
    }

    /**
     * Method: sizeOf()
     */
    @Test
    public void testSizeOf() throws Exception {
        AddressList list = new AddressList();

        Assert.assertTrue( "sizeOf Failed", list.sizeOf() == 0 );

        list.addToFront( "", "", "", "", "" );
        list.addToFront( "", "", "", "", "" );
        list.addToFront( "", "", "", "", "" );
        list.addToFront( "", "", "", "", "" );

        Assert.assertTrue( "sizeOf Failed", list.sizeOf() == 4 );
    }

    /**
     * Method: phoneNumberByName(String name)
     */
    @Test
    public void testPhoneNumberByName() throws Exception {
        AddressList list = new AddressList();

        Assert.assertTrue( "No matching data.".equals( list.phoneNumberByName( "Andrew" ) ) );
        Assert.assertTrue( "No matching data.".equals( list.phoneNumberByName( "Tika" ) ) );

        list.addToFront( "Andrew", "8049331266",
                "redtoorange@gmail.com", "817 Canyon Ridge",
                "10291987" );
        list.addToFront( "Tika", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );

        Assert.assertTrue( "8049331266".equals( list.phoneNumberByName( "Andrew" ) ) );
        Assert.assertTrue( "8045030784".equals( list.phoneNumberByName( "Tika" ) ) );
    }

    /**
     * Method: emailByName(String name)
     */
    @Test
    public void testEmailByName() throws Exception {
        AddressList list = new AddressList();

        Assert.assertTrue( "No matching data.".equals( list.emailByName( "Andrew" ) ) );
        Assert.assertTrue( "No matching data.".equals( list.emailByName( "Tika" ) ) );

        list.addToFront( "Andrew", "8049331266",
                "redtoorange@gmail.com", "817 Canyon Ridge",
                "10291987" );
        list.addToFront( "Tika", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );

        Assert.assertTrue( "redtoorange@gmail.com".equals( list.emailByName( "Andrew" ) ) );
        Assert.assertTrue( "tika.kotval@gmail.com".equals( list.emailByName( "Tika" ) ) );
    }

    /**
     * Method: nameByPhoneNumber(String tel)
     */
    @Test
    public void testNameByPhoneNumber() throws Exception {
        AddressList list = new AddressList();

        Assert.assertTrue( "No matching data.".equals( list.nameByPhoneNumber( "Andrew" ) ) );
        Assert.assertTrue( "No matching data.".equals( list.nameByPhoneNumber( "Tika" ) ) );

        list.addToFront( "Andrew", "8049331266",
                "redtoorange@gmail.com", "817 Canyon Ridge",
                "10291987" );
        list.addToFront( "Tika", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );

        Assert.assertTrue( "Andrew".equals( list.nameByPhoneNumber( "8049331266" ) ) );
        Assert.assertTrue( "Tika".equals( list.nameByPhoneNumber( "8045030784" ) ) );
    }

    /**
     * Method: dobByName(String name)
     */
    @Test
    public void testDobByName() throws Exception {
        AddressList list = new AddressList();

        Assert.assertTrue( "No matching data.".equals( list.dobByName( "Andrew" ) ) );
        Assert.assertTrue( "No matching data.".equals( list.dobByName( "Tika" ) ) );

        list.addToFront( "Andrew", "8049331266",
                "redtoorange@gmail.com", "817 Canyon Ridge",
                "10291987" );
        list.addToFront( "Tika", "8045030784",
                "tika.kotval@gmail.com", "817 Canyon Ridge",
                "12221988" );

        Assert.assertTrue( "10291987".equals( list.dobByName( "Andrew" ) ) );
        Assert.assertTrue( "12221988".equals( list.dobByName( "Tika" ) ) );
    }
} 
