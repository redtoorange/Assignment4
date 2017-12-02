import javax.swing.*;

/**
 * MainDriver.java - Description
 *
 * @author Andrew McGuiness
 * @version 12/2/2017
 */
public class MainDriver {
    public static void main( String[] args ) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

//            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }

        new MainWindow();
    }
}
