package main;

import javax.swing.*;

public class HomePage {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Pass the desired region as a parameter to the HomeFrame constructor
            HomeFrame homeFrame = new HomeFrame("Nigeria", null);
            
            // making sure it opens full screen
            homeFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            homeFrame.setUndecorated(true);
            homeFrame.setVisible(true);
        });
    }
}
