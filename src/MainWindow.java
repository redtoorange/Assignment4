import javax.swing.*;
import java.awt.*;

import static AppConstants.*;

/**
 * MainWindow.java - This class is the View of the Application.  It has input fields for user input, buttons to control
 * the underlying data structure(AddressList) and a TextArea that allows for application output.
 *
 * @author Andrew McGuiness
 * @version 12/2/2017
 */
public class MainWindow extends JFrame {
    private JPanel rootPanel;
    private AddressList list;

    private JTextField nameField;
    private JTextField telField;
    private JTextField emailField;
    private JTextField addrField;
    private JTextField dobField;

    private JTextArea outputArea;


    /** Create and display a new instance of the MainWindow. */
    public MainWindow() {
        list = new AddressList();

        initGUI();

        setVisible( true );
    }

    /** Initialize the Components of the Window */
    private void initGUI() {
        // Setup the Window
        setSize( WINDOW_WIDTH, WINDOW_HEIGHT );
        setTitle( WINDOW_TITLE );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        // Setup the rootPanel
        rootPanel = new JPanel();
        rootPanel.setLayout( null );
        setContentPane( rootPanel );

        // Create an add content to the rootPanel
        initDataPanel();
        initButtonPanel();
        initSearchPanel();
        initOutputArea();
    }

    /** Initialize and add the Output TextArea */
    private void initOutputArea() {
        outputArea = new JTextArea();

        JScrollPane pane = new JScrollPane( outputArea );
        pane.setBounds( OUTPUT_X_POS, OUTPUT_Y_POS, OUTPUT_WIDTH, OUTPUT_HEIGHT );

        rootPanel.add( pane );
    }

    /** Initialize and add all the Labels and TextFields for the user input */
    private void initDataPanel() {
        JPanel dataPanel = new JPanel( new GridBagLayout() );
        dataPanel.setBounds( DATA_X_POS, DATA_Y_POS, DATA_WIDTH, DATA_HEIGHT );
        rootPanel.add( dataPanel );

        int insetAmount = 2;
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, 0, new Insets( insetAmount, insetAmount, insetAmount, insetAmount ), 0, 0 );


        // Add labels to the DataPanel
        Dimension labelDimension = new Dimension( 60, 25 );
        String[] labels = { "Name", "Telephone", "Email", "Address", "DOB" };

        for ( int i = 0; i < labels.length; i++ ) {
            gbc.gridy = i;
            dataPanel.add( createLabel( labels[i], JLabel.RIGHT, labelDimension ), gbc );
        }


        // Add JTextFields to the DataPanel
        int fieldCols = 80;
        Dimension fieldDimension = new Dimension( 125, 25 );

        nameField = createField( fieldCols, fieldDimension );
        addToPanel( dataPanel, nameField, gbc, 1, 0 );


        telField = createField( fieldCols, fieldDimension );
        addToPanel( dataPanel, telField, gbc, 1, 1 );


        emailField = createField( fieldCols, fieldDimension );
        addToPanel( dataPanel, emailField, gbc, 1, 2 );


        addrField = createField( fieldCols, fieldDimension );
        addToPanel( dataPanel, addrField, gbc, 1, 3 );


        dobField = createField( fieldCols, fieldDimension );
        addToPanel( dataPanel, dobField, gbc, 1, 4 );
    }

    /** Initialize and add all of the buttons that allow operations on the AddressList */
    private void initButtonPanel() {
        JPanel buttonPanel = new JPanel( new GridBagLayout() );
        buttonPanel.setBounds( BUTTON_X_POS, BUTTON_Y_POS, BUTTON_WIDTH, BUTTON_HEIGHT );
        rootPanel.add( buttonPanel );

        int insetAmount = 1;
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, 0,
                new Insets( insetAmount, insetAmount, insetAmount, insetAmount ), 0, 0 );
        Dimension buttonDim = new Dimension( 120, 30 );

        // addToFront Button
        JButton button = getButton( "addToFront", buttonDim );
        button.addActionListener( ( e ) -> list.addToFront(
                nameField.getText(), telField.getText(), emailField.getText(), addrField.getText(), dobField.getText()
        ) );
        addToPanel( buttonPanel, button, gbc, 0, 0 );

        // addToBack Button
        button = getButton( "addToBack", buttonDim );
        button.addActionListener( ( e ) -> list.addToBack(
                nameField.getText(), telField.getText(), emailField.getText(), addrField.getText(), dobField.getText()
        ) );
        addToPanel( buttonPanel, button, gbc, 1, 0 );

        // toString Button
        button = getButton( "toString", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append( list.toString() ) );
        addToPanel( buttonPanel, button, gbc, 0, 1 );

        // reverseToString Button
        button = getButton( "reverseToString", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append( list.reverseToString() ) );
        addToPanel( buttonPanel, button, gbc, 1, 1 );

        // reverse Button
        button = getButton( "reverse", buttonDim );
        button.addActionListener( ( e ) -> list = list.reverse() );
        addToPanel( buttonPanel, button, gbc, 0, 2 );

        // isEmpty Button
        button = getButton( "isEmpty", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append( "List is Empty: " + list.isEmpty() + "\n" ) );
        addToPanel( buttonPanel, button, gbc, 1, 2 );

        // sizeOf Button
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        button = getButton( "sizeOf", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append( "List Size: " + list.sizeOf() + "\n" ) );
        addToPanel( buttonPanel, button, gbc, 0, 3 );
    }

    /** Initialize and add the buttons to allow searching the AddressList for certain values */
    private void initSearchPanel() {
        // Create the JPanel to hold the buttons
        JPanel searchPanel = new JPanel( new GridBagLayout() );
        searchPanel.setBounds( AppConstants.SEARCH_X_POS, SEARCH_Y_POS, SEARCH_WIDTH, SEARCH_HEIGHT );
        rootPanel.add( searchPanel );

        // Setup the Constraints for the layout
        int insetAmount = 1;
        GridBagConstraints gbc = new GridBagConstraints(
                0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, 0,
                new Insets( insetAmount, insetAmount, insetAmount, insetAmount ), 0, 0 );
        Dimension buttonDim = new Dimension( 200, 30 );

        // phoneNumberByName button
        JButton button = getButton( "Phone Number by Name", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append(
                "Phone number for " + nameField.getText() + ": " + list.phoneNumberByName( nameField.getText() ) + "\n"
        ) );
        addToPanel( searchPanel, button, gbc, 0, 0 );

        // emailByName button
        button = getButton( "Email by Name", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append(
                "Email for " + nameField.getText() + ": " + list.emailByName( nameField.getText() ) + "\n"
        ) );
        addToPanel( searchPanel, button, gbc, 0, 1 );

        // dobByName button
        button = getButton( "DOB by Name", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append(
                "DOB for " + nameField.getText() + ": " + list.dobByName( nameField.getText() ) + "\n"
        ) );
        addToPanel( searchPanel, button, gbc, 1, 0 );

        // nameByPhoneNumber button
        button = getButton( "Name by Phone Number", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append(
                "Name for " + telField.getText() + ": " + list.nameByPhoneNumber( telField.getText() ) + "\n"
        ) );
        addToPanel( searchPanel, button, gbc, 1, 1 );
    }


    /**
     * Helper method to create basic JLabel.
     *
     * @param text      Text to display in the JLabel.
     * @param alignment Text alignment.
     * @param dimension Dimension object to use to control the Object's size.
     * @return Newly created JLabel
     */
    private JLabel createLabel( String text, int alignment, Dimension dimension ) {
        JLabel label = new JLabel( text, alignment );
        label.setMinimumSize( dimension );

        return label;
    }

    /**
     * Helper method to create basic JButton.
     *
     * @param text      Text to display on the JButton.
     * @param dimension Dimension object to use to control the Object's size.
     * @return Newly created JButton
     */
    private JButton getButton( String text, Dimension dimension ) {
        JButton button = new JButton( text );

        button.setMinimumSize( dimension );
        button.setPreferredSize( dimension );
        button.setMaximumSize( dimension );

        return button;
    }

    /**
     * Helper method to create basic JTextField.
     *
     * @param cols      Number of cols to initialize the JTextField to have.
     * @param dimension Dimension object to use to control the Object's size.
     * @return Newly created JTextField
     */
    private JTextField createField( int cols, Dimension dimension ) {
        JTextField textField = new JTextField( cols );

        textField.setMinimumSize( dimension );
        textField.setMaximumSize( dimension );
        textField.setPreferredSize( dimension );

        return textField;
    }

    /**
     * Add a component to a JPanel with the provided GridBagConstraints and x,y position.  JPanel is assumed to be using
     * a GridBagLayout LayoutManager.
     *
     * @param target JPanel to add obj to
     * @param obj    Component to add to target
     * @param gbc    GridBagConstraints to use when adding and to modify the x, y position for
     * @param x      int x position of the Component in the GridBagLayout
     * @param y      int y position of the Component in the GridBagLayout
     */
    private void addToPanel( JPanel target, Component obj, GridBagConstraints gbc, int x, int y ) {
        gbc.gridx = x;
        gbc.gridy = y;
        target.add( obj, gbc );
    }
}
