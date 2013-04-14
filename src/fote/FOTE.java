/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fote;

import fote.gui.Login;
import fote.util.MongoHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author bobnisco
 */
public class FOTE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            MongoHelper.setDB("fote");
            Login login = new Login();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FOTE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FOTE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FOTE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FOTE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
