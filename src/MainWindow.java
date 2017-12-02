import javax.swing.*;
import java.awt.*;

/**
 * MainWindow.java - Description
 *
 * @author Andrew McGuiness
 * @version 12/2/2017
 */
public class MainWindow extends JFrame {
    private static int WIDTH = 500;
    private static int HEIGHT = 500;
    private static String TITLE = "Some Cool Window";

    private JPanel rootPanel;
    private AddressList list;

    private JTextField nameField;
    private JTextField telField;
    private JTextField emailField;
    private JTextField addrField;
    private JTextField dobField;

    private JTextArea outputArea;


    public MainWindow() {
        list = new AddressList();

        setSize( WIDTH, HEIGHT );
        setTitle( TITLE );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        initGUI();

        setVisible( true );
    }

    private void initGUI() {
        rootPanel = new JPanel();
        rootPanel.setLayout( null );

        setContentPane( rootPanel );

        initDataPanel();
        initButtonPanel();
        initSearchPanel();

        initOutputArea();
    }

    private void initOutputArea(){
        outputArea = new JTextArea(  );
        JScrollPane pane = new JScrollPane( outputArea );
//        pane.setBorder( new BorderUIResource.LineBorderUIResource( Color.RED ) );
        pane.setBounds( 10, 225, 460, 225 );

        rootPanel.add( pane );
    }

    private void initDataPanel() {
        JPanel dataPanel = new JPanel( new GridBagLayout() );
        dataPanel.setBounds( 0, 0, 200, 150 );
//        dataPanel.setBorder( new BorderUIResource.LineBorderUIResource( Color.RED ) );
        rootPanel.add( dataPanel );

        int insetAmount = 2;
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, 0, new Insets( insetAmount, insetAmount, insetAmount, insetAmount ), 0, 0 );



        // Add labels to the DataPanel
        Dimension labelDimension = new Dimension( 60, 25 );
        String[] labels = { "Name", "Telephone", "Email", "Address", "DOB" };

        for( int i = 0; i < labels.length; i++){
            gbc.gridy = i;
            dataPanel.add( createLabel(labels[i], JLabel.RIGHT, labelDimension), gbc );
        }



        // Add field to the DataPanel
        gbc.gridx = 1;
        gbc.gridy = 0;

        int fieldCols = 80;
        Dimension fieldDimension = new Dimension( 125, 25 );

        nameField = createField( fieldCols, fieldDimension );
        dataPanel.add( nameField, gbc );

        gbc.gridy++;
        telField = createField( fieldCols, fieldDimension );
        dataPanel.add( telField, gbc );


        gbc.gridy++;
        emailField = createField( fieldCols, fieldDimension );
        dataPanel.add( emailField, gbc );

        gbc.gridy++;
        addrField = createField( fieldCols, fieldDimension );
        dataPanel.add( addrField, gbc );

        gbc.gridy++;
        dobField = createField( fieldCols, fieldDimension );
        dataPanel.add( dobField, gbc );
    }

    private JTextField createField( int cols, Dimension dimension ){
        JTextField textField = new JTextField( cols );

        textField.setMinimumSize( dimension );
        textField.setMaximumSize( dimension );
        textField.setPreferredSize( dimension );

        return textField;
    }


    private void initButtonPanel() {
        JPanel buttonPanel = new JPanel( new GridBagLayout() );
        buttonPanel.setBounds( 200, 0, 275, 150 );
//        buttonPanel.setBorder( new BorderUIResource.LineBorderUIResource( Color.RED ) );
        rootPanel.add( buttonPanel );

        int insetAmount = 1;
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, 0,
                new Insets( insetAmount, insetAmount, insetAmount, insetAmount ), 0, 0 );

        int buttonWidth = 120;
        int buttonHeight = 30;
        Dimension buttonDim = new Dimension( buttonWidth, buttonHeight );

        JButton button = getButton( "addToFront", buttonDim );
        button.addActionListener( ( e ) -> list.addToFront(
                nameField.getText(), telField.getText(), emailField.getText(), addrField.getText(), dobField.getText()
        ) );
        buttonPanel.add( button, gbc );

        gbc.gridx = 1;
        button = getButton( "addToBack", buttonDim );
        button.addActionListener( ( e ) -> list.addToBack(
                nameField.getText(), telField.getText(), emailField.getText(), addrField.getText(), dobField.getText()
        ) );
        buttonPanel.add( button, gbc );

        gbc.gridx = 0;
        gbc.gridy = 1;
        button = getButton( "toString", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append( list.toString() ) );
        buttonPanel.add( button, gbc );

        gbc.gridx = 1;
        button = getButton( "reverseToString", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append( list.reverseToString() ) );
        buttonPanel.add( button, gbc );

        gbc.gridx = 0;
        gbc.gridy = 2;
        button = getButton( "reverse", buttonDim );
        button.addActionListener( ( e ) -> list = list.reverse() );
        buttonPanel.add( button, gbc );

        gbc.gridx = 1;
        button = getButton( "isEmpty", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append( "List is Empty: " + list.isEmpty() + "\n") );
        buttonPanel.add( button, gbc );


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        button = getButton( "sizeOf", buttonDim );
        button.addActionListener( ( e ) -> outputArea.append( "List Size: " + list.sizeOf() + "\n") );
        buttonPanel.add( button, gbc );
    }

    private void initSearchPanel(){
        JPanel buttonPanel = new JPanel( new GridBagLayout() );
        buttonPanel.setBounds( 0, 150, 475, 75 );
//        buttonPanel.setBorder( new BorderUIResource.LineBorderUIResource( Color.RED ) );
        rootPanel.add( buttonPanel );

        int insetAmount = 1;
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, 0,
                new Insets( insetAmount, insetAmount, insetAmount, insetAmount ), 0, 0 );

        int buttonWidth = 200;
        int buttonHeight = 30;
        Dimension buttonDim = new Dimension( buttonWidth, buttonHeight );

        JButton button = getButton( "Phone Number by Name", buttonDim );
        button.addActionListener( (e) -> outputArea.append(
                "Phone number for " + nameField.getText() + ": " + list.phoneNumberByName( nameField.getText() ) + "\n"
        ) );
        buttonPanel.add( button, gbc );

        gbc.gridy = 1;
        button = getButton( "Email by Name", buttonDim );
        button.addActionListener( (e) -> outputArea.append(
                "Email for " + nameField.getText() + ": " + list.emailByName( nameField.getText() ) + "\n"
        ) );
        buttonPanel.add( button, gbc );

        gbc.gridx = 1;
        gbc.gridy = 0;
        button = getButton( "DOB by Name", buttonDim );
        button.addActionListener( (e) -> outputArea.append(
                "DOB for " + nameField.getText() + ": " + list.dobByName( nameField.getText() ) + "\n"
        ) );
        buttonPanel.add( button, gbc );

        gbc.gridy = 1;
        button = getButton( "Name by Phone Number", buttonDim );
        button.addActionListener( (e) -> outputArea.append(
                "Name for " + telField.getText() + ": " + list.nameByPhoneNumber( telField.getText() ) + "\n"
        ) );
        buttonPanel.add( button, gbc );
    }

    private JLabel createLabel( String text, int alignment, Dimension dimension){
        JLabel label = new JLabel( text, alignment );
        label.setMinimumSize( dimension );

        return label;
    }


    private JButton getButton( String text, Dimension dimension ) {
        JButton button = new JButton( text );

        button.setMinimumSize( dimension );
        button.setPreferredSize( dimension );
        button.setMaximumSize( dimension );

        return button;
    }

}
