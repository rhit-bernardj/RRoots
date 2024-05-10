package main;

import javax.swing.*;
//starts everything
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartFrame startFrame = new StartFrame();
            startFrame.setVisible(true);
        });
    }
}
