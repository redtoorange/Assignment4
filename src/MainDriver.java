import javax.swing.*;

/**
 * MainDriver.java - Main Application entry point.  It attempts to set the look
 * and feel to Nimbus, this it loads and launches the ListGUI, which controls
 * the rest of the application.
 *
 * @author Andrew McGuiness
 * @version 12/2/2017
 */
public class MainDriver {
    public static void main( String[] args ) {
        try {
            for ( UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels() ) {
                if ( "Nimbus".equals( info.getName() ) ) {
                    UIManager.setLookAndFeel( info.getClassName() );
                    break;
                }
            }
        } catch ( Exception e ) {
            System.err.println(
                    "Failed to load \"Nimbus\" Look and Feel.  " +
                            "Proceeding with System Default."
            );
        }

        new ListGUI();
    }
}
