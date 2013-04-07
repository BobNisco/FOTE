/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fote.gui;

import javax.swing.UIManager;

/**
 *
 * @author Evan
 */
public class FoteGUI {
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            MainFrame frame = new MainFrame();

            frame.setVisible(true);
            
            ViewProposal prop = new ViewProposal(frame, true);
            prop.setVisible(true);
            
            ViewResults propResults = new ViewResults(frame, true);
            propResults.setVisible(true);
            
            ViewSuggestion sug = new ViewSuggestion(frame, true);
            sug.setVisible(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
